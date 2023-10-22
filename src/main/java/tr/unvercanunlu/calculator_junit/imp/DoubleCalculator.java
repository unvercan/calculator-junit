package tr.unvercanunlu.calculator_junit.imp;

import lombok.*;
import tr.unvercanunlu.calculator_junit.ICalculator;
import tr.unvercanunlu.calculator_junit.Operation;

import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@NoArgsConstructor
public class DoubleCalculator implements ICalculator<Double> {

    private boolean isValid(Operation operation, Double... inputs) {
        return (inputs != null) && (operation != null) && (inputs.length > 0)
                && Arrays.stream(inputs).allMatch(Objects::nonNull);
    }

    private Double processInputs(Operation operation, Double... inputs) {
        if (!this.isValid(operation, inputs)) {
            return Double.NaN;
        }

        Double result = inputs[0];

        for (int i = 1; i < inputs.length; i++) {
            Double input = inputs[i];

            switch (operation) {
                case ADD -> result += input;
                case SUBTRACT -> result -= input;
                case MULTIPLY -> result *= input;
                case DIVIDE -> result /= input;
            }
        }

        return result;
    }

    @Override
    public Double add(Double... inputs) {
        return this.processInputs(Operation.ADD, inputs);
    }

    @Override
    public Double subtract(Double... inputs) {
        return this.processInputs(Operation.SUBTRACT, inputs);
    }

    @Override
    public Double multiply(Double... inputs) {
        return this.processInputs(Operation.MULTIPLY, inputs);
    }

    @Override
    public Double divide(Double... inputs) {
        return this.processInputs(Operation.DIVIDE, inputs);
    }
}
