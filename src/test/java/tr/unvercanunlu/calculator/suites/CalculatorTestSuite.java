package tr.unvercanunlu.calculator.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tr.unvercanunlu.calculator.imp.AddCalculatorTestCasesImp;
import tr.unvercanunlu.calculator.imp.DivideCalculatorTestCasesImp;
import tr.unvercanunlu.calculator.imp.MultiplyCalculatorTestCasesImp;
import tr.unvercanunlu.calculator.imp.SubtractCalculatorTestCasesImp;

@RunWith(Suite.class)

@SuiteClasses({
		AddCalculatorTestCasesImp.class,
		SubtractCalculatorTestCasesImp.class,
		MultiplyCalculatorTestCasesImp.class,
		DivideCalculatorTestCasesImp.class
})

public class CalculatorTestSuite {
}