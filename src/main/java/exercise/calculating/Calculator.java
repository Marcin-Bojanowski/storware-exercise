package exercise.calculating;

import exercise.filereading.FileInput;
import exercise.filereading.Instruction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final OperationFactory operationFactory;

    public Double calculate(FileInput fileInput) {
        Double result = fileInput.getNumberToApply().doubleValue();
        for (Instruction instruction : fileInput.getListOfInstruction()) {
            Operation operation = operationFactory.findOperation(instruction.getName());
            result = operation.calculate(result, instruction.getValue());
        }
        return result;
    }
}
