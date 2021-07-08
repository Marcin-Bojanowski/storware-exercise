package exercise.filereading;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

@Component
public class FileInputProvider {

    private final String FILE_NAME = "/input.txt";

    public Scanner getInput() {
        InputStream inputStream = getClass().getResourceAsStream(FILE_NAME);
        return new Scanner(inputStream);
    }
}
