package exercise.calculating;

import exercise.OperationType;

public interface Operation {

    double calculate(double a, double b);

    OperationType getOperationName();
}
