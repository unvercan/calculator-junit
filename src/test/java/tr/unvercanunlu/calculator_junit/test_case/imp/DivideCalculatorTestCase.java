package tr.unvercanunlu.calculator_junit.test_case.imp;

import junit.framework.TestCase;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import tr.unvercanunlu.calculator_junit.test_case.ICalculatorTestCase;
import tr.unvercanunlu.calculator_junit.test_runner.CalculatorTestCaseRunner;

@RunWith(value = CalculatorTestCaseRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class DivideCalculatorTestCase extends TestCase implements ICalculatorTestCase {

    @SneakyThrows
    @Before
    @Override
    public void setUp() {
        super.setUp();
    }

    @SneakyThrows
    @After
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    @Override
    public void testWithNoInput() {
        Double actual = calculator.divide();
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithSingleNullInput() {
        Double actual = calculator.divide(null);
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithSinglePrimitiveInput() {
        Double actual = calculator.divide(primitive);
        assertEquals(primitive, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithSingleObjectInput() {
        Double actual = calculator.divide(object);
        assertEquals(object, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleNullInput() {
        Double actual = calculator.divide(null, null, null, null, null);
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultiplePrimitiveInputs() {
        double expected = primitive / primitive / primitive / primitive / primitive;
        Double actual = calculator.divide(primitive, primitive, primitive, primitive, primitive);
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleObjectInputs() {
        Double expected = object / object / object / object / object;
        Double actual = calculator.divide(object, object, object, object, object);
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleMixedPrimitiveAndNullInputs() {
        Double actual = calculator.divide(null, null, primitive, primitive, null);
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleMixedPrimitiveAndObjectInputs() {
        Double expected = primitive / primitive / object / object / primitive;
        Double actual = calculator.divide(primitive, primitive, object, object, primitive);
        assertEquals(expected, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleMixedPrimitiveObjectAndNullInputs() {
        Double actual = calculator.divide(null, null, primitive, object, null);
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }

    @Test
    @Override
    public void testWithMultipleMixedObjectAndNullInputs() {
        Double actual = calculator.divide(null, null, object, object, null);
        assertEquals(Double.NaN, actual);
        assertNotNull(actual);
    }
}
