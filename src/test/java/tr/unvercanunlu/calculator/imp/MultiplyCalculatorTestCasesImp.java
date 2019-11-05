package tr.unvercanunlu.calculator.imp;

import junit.framework.TestCase;
import org.junit.Test;
import tr.unvercanunlu.calculator.Calculator;
import tr.unvercanunlu.calculator.CalculatorTestCases;

public class MultiplyCalculatorTestCasesImp extends TestCase implements CalculatorTestCases {

	// primitive
	private double primitive;

	// object
	private Double object;

	// calculator
	private Calculator<Double> calculator;

	@Override
	public void setUp() throws Exception {
		super.setUp();

		// primitive
		this.primitive = -123456789.123456789D;

		// object
		this.object = new Double(-123456789.123456789D);

		// calculator
		this.calculator = MyDoubleCalculator.getInstance();
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testWithNoInput() {
		Double expected = Double.NaN;
		Double actual = this.calculator.multiply();
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleNullInput() {
		Double expected = Double.NaN;
		Double input = null;
		Double actual = this.calculator.multiply(input);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSinglePrimitiveInput() {
		double expected = this.primitive;
		Double actual = this.calculator.multiply(this.primitive);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleObjectInput() {
		Double expected = this.object;
		Double actual = this.calculator.multiply(this.object);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleNullInput() {
		Double expected = Double.NaN;
		Double actual = this.calculator.multiply(null, null, null, null, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultiplePrimitiveInputs() {
		double expected = this.primitive * this.primitive * this.primitive * this.primitive * this.primitive;
		Double actual = this.calculator.multiply(this.primitive, this.primitive, this.primitive, this.primitive, this.primitive);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleObjectInputs() {
		Double expected = this.object * this.object * this.object * this.object * this.object;
		Double actual = this.calculator.multiply(this.object, this.object, this.object, this.object, this.object);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndNullInputs() {
		double expected = this.primitive * this.primitive;
		Double actual = this.calculator.multiply(null, null, this.primitive, this.primitive, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndObjectInputs() {
		Double expected = this.primitive * this.primitive * this.object * this.object * this.primitive;
		Double actual = this.calculator.multiply(this.primitive, this.primitive, this.object, this.object, this.primitive);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveObjectAndNullInputs() {
		Double expected = this.primitive * this.object;
		Double actual = this.calculator.multiply(null, null, this.primitive, this.object, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedObjectAndNullInputs() {
		Double expected = this.object * this.object;
		Double actual = this.calculator.multiply(null, null, this.object, this.object, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}
}