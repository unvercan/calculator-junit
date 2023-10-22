package tr.unvercanunlu.calculator_junit.test_config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.Ignore;
import org.junit.Test;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculatorTestConfig {

    public final static String runnerDescription = "Calculator Test Case Runner";

    public final static String setUpMethodName = "setUp";

    public final static String tearDownMethodName = "tearDown";

    public final static Class<Test> testAnnotationClass = Test.class;

    public final static Class<Ignore> testIgnoreAnnotationClass = Ignore.class;

}
