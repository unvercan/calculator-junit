package tr.unvercanunlu.calculator_junit.test_runner;

import junit.framework.TestCase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import tr.unvercanunlu.calculator_junit.test_case.ICalculatorTestCase;
import tr.unvercanunlu.calculator_junit.test_config.CalculatorTestConfig;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class CalculatorTestCaseRunner extends Runner {

    private final Class<ICalculatorTestCase> testClass;

    @Override
    public Description getDescription() {
        return Description.createTestDescription(testClass.getName(), CalculatorTestConfig.runnerDescription);
    }

    @SneakyThrows
    @Override
    public void run(RunNotifier notifier) {
        Constructor<ICalculatorTestCase> testObjectConstructor = testClass.getDeclaredConstructor();

        Object testObject = testObjectConstructor.newInstance();

        if (testObject instanceof TestCase) {
            Method setUpMethod = Arrays.stream(testClass.getMethods())
                    .filter(method -> method.getName().equals(CalculatorTestConfig.setUpMethodName))
                    .findFirst()
                    .orElseThrow(NoSuchMethodException::new);

            Method tearDownMethod = Arrays.stream(testClass.getMethods())
                    .filter(method -> method.getName().equals(CalculatorTestConfig.tearDownMethodName))
                    .findFirst()
                    .orElseThrow(NoSuchMethodException::new);

            List<Method> testMethods = Arrays.stream(testClass.getMethods())
                    .filter(method -> method.isAnnotationPresent(CalculatorTestConfig.testAnnotationClass)
                            && !method.isAnnotationPresent(CalculatorTestConfig.testIgnoreAnnotationClass))
                    .toList();

            for (Method method : testMethods) {
                notifier.fireTestStarted(Description.createTestDescription(testClass.getName(), method.getName()));

                setUpMethod.invoke(testObject);

                method.invoke(testObject);

                tearDownMethod.invoke(testObject);

                notifier.fireTestFinished(Description.createTestDescription(testClass.getName(), method.getName()));

            }
        } else {
            throw new ClassNotFoundException();
        }
    }
}
