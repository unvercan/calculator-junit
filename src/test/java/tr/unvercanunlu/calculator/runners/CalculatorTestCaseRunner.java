package tr.unvercanunlu.calculator.runners;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

public class CalculatorTestCaseRunner extends Runner {

	// constants
	private static final String runnerDescription = "Calculator Test Case Runner";
	private static final String setUpMethodName = "setUp";
	private static final String tearDownMethodName = "tearDown";
	private static final Class testAnnotationClass = Test.class;

	// fields
	private Class testClass;

	// constructors
	public CalculatorTestCaseRunner() {
	}

	public CalculatorTestCaseRunner(Class testClass) {
		super();
		this.testClass = testClass;
	}

	// getters
	public Class getTestClass() {
		return this.testClass;
	}

	// setters
	public void setTestClass(Class testClass) {
		this.testClass = testClass;
	}

	@Override
	public Description getDescription() {
		return Description.createTestDescription(this.testClass.getName(), runnerDescription);
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			Object testObject = this.testClass.newInstance();
			if (testObject instanceof TestCase) {
				Method setUpMethod = null;
				Method tearDownMethod = null;
				Method[] methods = this.testClass.getMethods();
				for (Method method : methods) {
					if (method.getName().equals(setUpMethodName))
						setUpMethod = method;
					else if (method.getName().equals(tearDownMethodName))
						tearDownMethod = method;
				}
				if (setUpMethod == null || tearDownMethod == null)
					throw new NoSuchMethodException();
				else
					for (Method method : this.testClass.getMethods()) {
						if (method.isAnnotationPresent(testAnnotationClass)) {
							notifier.fireTestStarted(Description.createTestDescription(this.testClass.getName(), method.getName()));
							setUpMethod.invoke(testObject);
							method.invoke(testObject);
							tearDownMethod.invoke(testObject);
							notifier.fireTestFinished(Description.createTestDescription(this.testClass.getName(), method.getName()));
						}
					}
			} else throw new ClassNotFoundException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}