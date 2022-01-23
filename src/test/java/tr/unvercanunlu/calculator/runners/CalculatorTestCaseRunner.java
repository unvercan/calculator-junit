package tr.unvercanunlu.calculator.runners;

import junit.framework.TestCase;
import lombok.Getter;
import lombok.Setter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

@Getter
@Setter
public class CalculatorTestCaseRunner extends Runner {

	// constants
	private static final String runnerDescription = "Calculator Test Case Runner";
	private static final String setUpMethodName = "setUp";
	private static final String tearDownMethodName = "tearDown";
	private static final Class testAnnotationClass = Test.class;
	private static final Class testIgnoreAnnotationClass = Ignore.class;

	// fields
	private Class testClass;

	// constructor
	public CalculatorTestCaseRunner(Class testClass) {
		super();
		this.testClass = testClass;
	}

	@Override
	public Description getDescription() {
		return Description.createTestDescription(testClass.getName(), runnerDescription);
	}

	@Override
	public void run(RunNotifier notifier) {
		try{
			Object testObject = testClass.newInstance();
			if(testObject instanceof TestCase){
				Method setUpMethod = null;
				Method tearDownMethod = null;
				Method[] methods = testClass.getMethods();
				for(Method method : methods){
					if(method.getName().equals(setUpMethodName)){
						setUpMethod = method;
					} else if(method.getName().equals(tearDownMethodName)){
						tearDownMethod = method;
					}
				}
				if(setUpMethod == null || tearDownMethod == null){
					throw new NoSuchMethodException();
				} else{
					for(Method method : testClass.getMethods()){
						if(method.isAnnotationPresent(testAnnotationClass) && !method.isAnnotationPresent(testIgnoreAnnotationClass)){
							notifier.fireTestStarted(Description.createTestDescription(testClass.getName(), method.getName()));
							setUpMethod.invoke(testObject);
							method.invoke(testObject);
							tearDownMethod.invoke(testObject);
							notifier.fireTestFinished(Description.createTestDescription(testClass.getName(), method.getName()));
						}
					}
				}
			} else{
				throw new ClassNotFoundException();
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}