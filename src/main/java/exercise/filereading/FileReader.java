package exercise.filereading;

import exercise.OperationType;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class FileReader {


    private static final String SPLIT_REGEX = "\\s+";
    private final FileInputProvider fileInputProvider;


    public FileInput readFile() throws IOException {

        List<Instruction> instructions = new LinkedList();
        Scanner scanner = fileInputProvider.getInput();
        while (scanner.hasNextLine()) {
            String[] splited = scanner.nextLine().split(SPLIT_REGEX);
            if (EnumUtils.isValidEnumIgnoreCase(OperationType.class, splited[0])) {
                if (OperationType.APPLY.toString().equalsIgnoreCase(splited[0])) {
                    return FileInput.builder()
                            .numberToApply(Integer.parseInt(splited[1]))
                            .listOfInstruction(instructions)
                            .build();
                } else {
                    Instruction instruction = Instruction.builder()
                            .name(EnumUtils.getEnumIgnoreCase(OperationType.class, splited[0]))
                            .value(Integer.parseInt(splited[1]))
                            .build();
                    instructions.add(instruction);
                }
            }
        }
        throw new IllegalArgumentException("Brak operacji apply");
    }


}
