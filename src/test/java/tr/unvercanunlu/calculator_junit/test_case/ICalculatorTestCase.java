package tr.unvercanunlu.calculator_junit.test_case;

import org.junit.Ignore;
import org.junit.Test;
import tr.unvercanunlu.calculator_junit.ICalculator;
import tr.unvercanunlu.calculator_junit.imp.DoubleCalculator;

import static org.junit.Assert.*;

public interface ICalculatorTestCase {

    // fields
    double primitive = -123456789.123456789;

    Double object = -123456789.123456789;

    Object nullValue = null;

    ICalculator<Double> calculator = new DoubleCalculator();

    @Ignore(value = "Ignored Test")
    @Test
    default void testOfTest() {
        assertTrue(true);
        assertFalse(false);
        assertNull(nullValue);
        assertNotNull(calculator);
        assertEquals(primitive, object, 0);
        assertSame(null, nullValue);
        assertNotSame(object, nullValue);
    }

    void testWithNoInput();

    void testWithSingleNullInput();

    void testWithSinglePrimitiveInput();

    void testWithSingleObjectInput();

    void testWithMultipleNullInput();

    void testWithMultiplePrimitiveInputs();

    void testWithMultipleObjectInputs();

    void testWithMultipleMixedPrimitiveAndNullInputs();

    void testWithMultipleMixedObjectAndNullInputs();

    void testWithMultipleMixedPrimitiveAndObjectInputs();

    void testWithMultipleMixedPrimitiveObjectAndNullInputs();

}
