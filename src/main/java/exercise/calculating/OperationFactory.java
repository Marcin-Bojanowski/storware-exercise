package exercise.calculating;

import exercise.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class OperationFactory {

    private Map<OperationType, Operation> operations;

    @Autowired
    public OperationFactory(Set<Operation> operations) {
        createOperations(operations);
    }

    private void createOperations(Set<Operation> operationSet) {
        operations = new HashMap<>();
        operationSet.forEach(op -> operations.put(op.getOperationName(), op));
    }

    public Operation findOperation(OperationType operationType) {
        return operations.get(operationType);
    }
}
