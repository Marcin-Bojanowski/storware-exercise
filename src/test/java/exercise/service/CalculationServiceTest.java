package exercise.service;

import exercise.calculating.Calculator;
import exercise.filereading.FileInputProvider;
import exercise.filereading.FileReader;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CalculationServiceTest {

    @Mock
    private FileInputProvider fileInputProvider;

    @Autowired
    private Calculator calculator;

    @Test
    void givenCorrectInput_whenCalculate_thenGetCorrectResult() throws IOException {
        //given
        Scanner scanner = new Scanner("add 2\n" +
                "multiply 4\n" +
                "divide 2\n" +
                "subtract 1\n" +
                "apply 5");
        FileReader fileReader = new FileReader(fileInputProvider);
        CalculationService calculationService = new CalculationService(calculator, fileReader);
        when(fileInputProvider.getInput()).thenReturn(scanner);

        //when
        Double result = calculationService.calculate();

        //then
        assertEquals(13, result);
    }

    @Test
    void givenTwoApplyOperationsInInput_whenCalculate_thenGetResultForOnyFirstApply() throws IOException {
        //given
        Scanner scanner = new Scanner("add 2\n" +
                "multiply 4\n" +
                "apply 2\n" +
                "subtract 1\n" +
                "apply 5");
        FileReader fileReader = new FileReader(fileInputProvider);
        CalculationService calculationService = new CalculationService(calculator, fileReader);
        when(fileInputProvider.getInput()).thenReturn(scanner);

        //when
        Double result = calculationService.calculate();

        //then
        assertEquals(16, result);
    }

    @Test
    void givenInputWithoutApply_whenCalculate_thenThrowillegalArgumentException() throws IOException {
        //given
        Scanner scanner = new Scanner("add 2\n" +
                "multiply 4\n" +
                "subtract 1\n");
        FileReader fileReader = new FileReader(fileInputProvider);
        CalculationService calculationService = new CalculationService(calculator, fileReader);
        when(fileInputProvider.getInput()).thenReturn(scanner);

        //when
        Exception exception=  assertThrows(IllegalArgumentException.class, calculationService::calculate);

        //then
        String expectedMessage = "Brak operacji apply";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}