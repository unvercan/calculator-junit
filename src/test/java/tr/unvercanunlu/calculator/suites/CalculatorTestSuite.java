package tr.unvercanunlu.calculator.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tr.unvercanunlu.calculator.cases.imp.AddCalculatorTestCase;
import tr.unvercanunlu.calculator.cases.imp.DivideCalculatorTestCase;
import tr.unvercanunlu.calculator.cases.imp.MultiplyCalculatorTestCase;
import tr.unvercanunlu.calculator.cases.imp.SubtractCalculatorTestCase;

@RunWith(Suite.class)

@SuiteClasses({
		AddCalculatorTestCase.class,
		SubtractCalculatorTestCase.class,
		MultiplyCalculatorTestCase.class,
		DivideCalculatorTestCase.class
})

public class CalculatorTestSuite {

}