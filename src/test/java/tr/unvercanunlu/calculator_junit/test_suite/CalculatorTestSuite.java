package tr.unvercanunlu.calculator_junit.test_suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tr.unvercanunlu.calculator_junit.test_case.imp.AddCalculatorTestCase;
import tr.unvercanunlu.calculator_junit.test_case.imp.DivideCalculatorTestCase;
import tr.unvercanunlu.calculator_junit.test_case.imp.MultiplyCalculatorTestCase;
import tr.unvercanunlu.calculator_junit.test_case.imp.SubtractCalculatorTestCase;

@RunWith(value = Suite.class)
@SuiteClasses(value = {
        AddCalculatorTestCase.class,
        SubtractCalculatorTestCase.class,
        MultiplyCalculatorTestCase.class,
        DivideCalculatorTestCase.class})
public class CalculatorTestSuite {
}
