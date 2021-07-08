package exercise.filereading;

import exercise.OperationType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Instruction {

    OperationType name;
    Integer value;
}
