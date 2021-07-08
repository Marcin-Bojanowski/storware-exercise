package exercise.service;

import exercise.calculating.Calculator;
import exercise.filereading.FileInput;
import exercise.filereading.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CalculationService {

    private final Calculator calculator;
    private final FileReader fileReader;

    @Autowired
    public CalculationService(Calculator calculator, FileReader fileReader) {
        this.calculator = calculator;
        this.fileReader = fileReader;
    }

    public Double calculate() {
        FileInput fileInput = null;
        try {
            fileInput = fileReader.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return calculator.calculate(fileInput);
    }

}
