package tr.unvercanunlu.calculator.cases.imp;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import tr.unvercanunlu.calculator.Calculator;
import tr.unvercanunlu.calculator.cases.CalculatorTestCase;
import tr.unvercanunlu.calculator.runners.CalculatorTestCaseRunner;

@RunWith(CalculatorTestCaseRunner.class)
public class DivideCalculatorTestCaseImp extends TestCase implements CalculatorTestCase {

	// fields
	private double primitive;
	private Double object;
	private Calculator<Double> calculator;

	// constructors
	public DivideCalculatorTestCaseImp() {
	}

	public DivideCalculatorTestCaseImp(double primitive, Double object, Calculator<Double> calculator) {
		this.primitive = primitive;
		this.object = object;
		this.calculator = calculator;
	}

	// getters
	public double getPrimitive() {
		return this.primitive;
	}

	public void setPrimitive(double primitive) {
		this.primitive = primitive;
	}

	public Double getObject() {
		return this.object;
	}

	// setters
	public void setObject(Double object) {
		this.object = object;
	}

	public Calculator<Double> getCalculator() {
		return this.calculator;
	}

	public void setCalculator(Calculator<Double> calculator) {
		this.calculator = calculator;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.setPrimitive(-123456789.123456789D);
		this.setObject(new Double(-123456789.123456789D));
		this.setCalculator(MyDoubleCalculator.getInstance());
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testWithNoInput() {
		Double expected = Double.NaN;
		Double actual = this.getCalculator().divide();
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleNullInput() {
		Double expected = Double.NaN;
		Double input = null;
		Double actual = this.getCalculator().divide(input);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSinglePrimitiveInput() {
		double expected = this.getPrimitive();
		Double actual = this.getCalculator().divide(this.getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleObjectInput() {
		Double expected = this.getObject();
		Double actual = this.getCalculator().divide(this.getObject());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleNullInput() {
		Double expected = Double.NaN;
		Double actual = this.getCalculator().divide(null, null, null, null, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultiplePrimitiveInputs() {
		double expected = this.getPrimitive() / this.getPrimitive() / this.getPrimitive() / this.getPrimitive() / this.getPrimitive();
		Double actual = this.getCalculator().divide(this.getPrimitive(), this.getPrimitive(), this.getPrimitive(), this.getPrimitive(), this.getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleObjectInputs() {
		Double expected = this.getObject() / this.getObject() / this.getObject() / this.getObject() / this.getObject();
		Double actual = this.getCalculator().divide(this.getObject(), this.getObject(), this.getObject(), this.getObject(), this.getObject());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndNullInputs() {
		double expected = this.getPrimitive() / this.getPrimitive();
		Double actual = this.getCalculator().divide(null, null, this.getPrimitive(), this.getPrimitive(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndObjectInputs() {
		Double expected = this.getPrimitive() / this.getPrimitive() / this.getObject() / this.getObject() / this.getPrimitive();
		Double actual = this.getCalculator().divide(this.getPrimitive(), this.getPrimitive(), this.getObject(), this.getObject(), this.getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveObjectAndNullInputs() {
		Double expected = this.getPrimitive() / this.getObject();
		Double actual = this.getCalculator().divide(null, null, this.getPrimitive(), this.getObject(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedObjectAndNullInputs() {
		Double expected = this.getObject() / this.getObject();
		Double actual = this.getCalculator().divide(null, null, this.getObject(), this.getObject(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}
}