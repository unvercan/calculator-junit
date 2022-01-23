package tr.unvercanunlu.calculator;

public interface ICalculator<T extends Number> {

	T add(T... inputs);

	T subtract(T... inputs);

	T multiply(T... inputs);

	T divide(T... inputs);
}