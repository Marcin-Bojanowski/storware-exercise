package exercise.calculating;

import exercise.OperationType;
import org.springframework.stereotype.Component;

@Component
public class Add implements Operation {
    @Override
    public double calculate(double a, double b) {
        return a + b;
    }

    @Override
    public OperationType getOperationName() {
        return OperationType.ADD;
    }
}
