package exercise.filereading;

import lombok.Builder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@Builder
public class FileInput {

    @Builder.Default
    List<Instruction> listOfInstruction = new ArrayList<>();
    Integer numberToApply;
}
