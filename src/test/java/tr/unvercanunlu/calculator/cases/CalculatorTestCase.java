package tr.unvercanunlu.calculator.cases;

import org.junit.Test;

public interface CalculatorTestCase {

	@Test
	void testWithNoInput();

	@Test
	void testWithSingleNullInput();

	@Test
	void testWithSinglePrimitiveInput();

	@Test
	void testWithSingleObjectInput();

	@Test
	void testWithMultipleNullInput();

	@Test
	void testWithMultiplePrimitiveInputs();

	@Test
	void testWithMultipleObjectInputs();

	@Test
	void testWithMultipleMixedPrimitiveAndNullInputs();

	@Test
	void testWithMultipleMixedObjectAndNullInputs();

	@Test
	void testWithMultipleMixedPrimitiveAndObjectInputs();

	@Test
	void testWithMultipleMixedPrimitiveObjectAndNullInputs();
}