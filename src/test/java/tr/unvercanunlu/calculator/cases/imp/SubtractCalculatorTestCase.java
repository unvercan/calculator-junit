package tr.unvercanunlu.calculator.cases.imp;

import junit.framework.TestCase;
import lombok.Getter;
import lombok.Setter;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import tr.unvercanunlu.calculator.ICalculator;
import tr.unvercanunlu.calculator.cases.ICalculatorTestCase;
import tr.unvercanunlu.calculator.imp.DoubleICalculator;
import tr.unvercanunlu.calculator.runners.CalculatorTestCaseRunner;

@Getter
@Setter
@RunWith(CalculatorTestCaseRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubtractCalculatorTestCase extends TestCase implements ICalculatorTestCase {

	// fields
	private double primitive;
	private Double object;
	private ICalculator<Double> calculator;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		setPrimitive(-123456789.123456789D);
		setObject(new Double(-123456789.123456789D));
		setCalculator(DoubleICalculator.getInstance());
	}

	@Override
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Ignore("Ignored Test")
	@Test
	public void testOfTest() {
		assertTrue(true);
		assertFalse(false);
		assertNotNull(getObject());
		assertNotNull(getCalculator());
		assertEquals(getPrimitive(), getPrimitive());
		assertEquals(getObject(), getObject());
		assertEquals(getCalculator(), getCalculator());
		assertSame(getObject(), getObject());
		assertSame(getCalculator(), getCalculator());
		assertNotSame(getObject(), getCalculator());
	}

	@Test
	public void testWithNoInput() {
		Double expected = Double.NaN;
		Double actual = getCalculator().subtract();
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleNullInput() {
		Double expected = Double.NaN;
		Double input = null;
		Double actual = getCalculator().subtract(input);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSinglePrimitiveInput() {
		double expected = getPrimitive();
		Double actual = getCalculator().subtract(getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithSingleObjectInput() {
		Double expected = getObject();
		Double actual = getCalculator().subtract(getObject());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleNullInput() {
		Double expected = Double.NaN;
		Double actual = getCalculator().subtract(null, null, null, null, null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultiplePrimitiveInputs() {
		double expected = getPrimitive() - getPrimitive() - getPrimitive() - getPrimitive() - getPrimitive();
		Double actual = getCalculator().subtract(getPrimitive(), getPrimitive(), getPrimitive(), getPrimitive(), getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleObjectInputs() {
		Double expected = getObject() - getObject() - getObject() - getObject() - getObject();
		Double actual = getCalculator().subtract(getObject(), getObject(), getObject(), getObject(), getObject());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndNullInputs() {
		double expected = getPrimitive() - getPrimitive();
		Double actual = getCalculator().subtract(null, null, getPrimitive(), getPrimitive(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveAndObjectInputs() {
		Double expected = getPrimitive() - getPrimitive() - getObject() - getObject() - getPrimitive();
		Double actual = getCalculator().subtract(getPrimitive(), getPrimitive(), getObject(), getObject(), getPrimitive());
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedPrimitiveObjectAndNullInputs() {
		Double expected = getPrimitive() - getObject();
		Double actual = getCalculator().subtract(null, null, getPrimitive(), getObject(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}

	@Test
	public void testWithMultipleMixedObjectAndNullInputs() {
		Double expected = getObject() - getObject();
		Double actual = getCalculator().subtract(null, null, getObject(), getObject(), null);
		assertEquals(expected, actual);
		assertNotNull(actual);
	}
}