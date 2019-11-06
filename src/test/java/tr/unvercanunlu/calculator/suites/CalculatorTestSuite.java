package tr.unvercanunlu.calculator.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tr.unvercanunlu.calculator.cases.imp.AddCalculatorTestCaseImp;
import tr.unvercanunlu.calculator.cases.imp.DivideCalculatorTestCaseImp;
import tr.unvercanunlu.calculator.cases.imp.MultiplyCalculatorTestCaseImp;
import tr.unvercanunlu.calculator.cases.imp.SubtractCalculatorTestCaseImp;

@RunWith(Suite.class)

@SuiteClasses({
		AddCalculatorTestCaseImp.class,
		SubtractCalculatorTestCaseImp.class,
		MultiplyCalculatorTestCaseImp.class,
		DivideCalculatorTestCaseImp.class
})

public class CalculatorTestSuite {
}