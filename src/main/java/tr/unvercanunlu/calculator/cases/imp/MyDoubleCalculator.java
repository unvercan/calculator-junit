package tr.unvercanunlu.calculator.cases.imp;

import tr.unvercanunlu.calculator.Calculator;

public class MyDoubleCalculator implements Calculator<Double> {

	// instance
	private static MyDoubleCalculator instance;

	// constructor
	private MyDoubleCalculator() {
	}

	// singleton get instance
	public static MyDoubleCalculator getInstance() {
		if (instance == null)
			instance = new MyDoubleCalculator();
		return instance;
	}

	public Double add(Double... inputs) {
		if (inputs.length == 0)
			return Double.NaN;
		else {
			boolean allNull = true;
			Double result = null;
			for (Double input : inputs) {
				if (input != null) {
					allNull = false;
					if (result != null)
						result += input;
					else result = input;
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	public Double subtract(Double... inputs) {
		if (inputs.length == 0)
			return Double.NaN;
		else {
			boolean allNull = true;
			Double result = null;
			for (Double input : inputs) {
				if (input != null) {
					allNull = false;
					if (result != null)
						result -= input;
					else result = input;
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	public Double multiply(Double... inputs) {
		if (inputs.length == 0)
			return Double.NaN;
		else {
			boolean allNull = true;
			Double result = null;
			for (Double input : inputs) {
				if (input != null) {
					allNull = false;
					if (result != null)
						result *= input;
					else result = input;
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	public Double divide(Double... inputs) {
		if (inputs.length == 0)
			return Double.NaN;
		else {
			boolean allNull = true;
			Double result = null;
			for (Double input : inputs) {
				if (input != null) {
					allNull = false;
					if (result != null)
						result /= input;
					else result = input;
				}
			}
			return allNull ? Double.NaN : result;
		}
	}
}