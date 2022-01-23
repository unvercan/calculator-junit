package tr.unvercanunlu.calculator.imp;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tr.unvercanunlu.calculator.ICalculator;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class DoubleICalculator implements ICalculator<Double>, Serializable {

	// instance
	private static DoubleICalculator instance;

	// singleton get instance
	public static DoubleICalculator getInstance() {
		if(instance == null){
			instance = new DoubleICalculator();
		}
		return instance;
	}

	@Override
	public Double add(Double... inputs) {
		if(inputs == null || inputs.length == 0){
			return Double.NaN;
		} else{
			boolean allNull = true;
			Double result = null;
			for(Double input : inputs){
				if(input != null){
					allNull = false;
					if(result != null){
						result += input;
					} else{
						result = input;
					}
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	@Override
	public Double subtract(Double... inputs) {
		if(inputs == null || inputs.length == 0){
			return Double.NaN;
		} else{
			boolean allNull = true;
			Double result = null;
			for(Double input : inputs){
				if(input != null){
					allNull = false;
					if(result != null){
						result -= input;
					} else{
						result = input;
					}
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	@Override
	public Double multiply(Double... inputs) {
		if(inputs == null || inputs.length == 0){
			return Double.NaN;
		} else{
			boolean allNull = true;
			Double result = null;
			for(Double input : inputs){
				if(input != null){
					allNull = false;
					if(result != null){
						result *= input;
					} else{
						result = input;
					}
				}
			}
			return allNull ? Double.NaN : result;
		}
	}

	@Override
	public Double divide(Double... inputs) {
		if(inputs == null || inputs.length == 0){
			return Double.NaN;
		} else{
			boolean allNull = true;
			Double result = null;
			for(Double input : inputs){
				if(input != null){
					allNull = false;
					if(result != null){
						result /= input;
					} else{
						result = input;
					}
				}
			}
			return allNull ? Double.NaN : result;
		}
	}
}