package com.vyacheslav.testscalculator.service;
import com.vyacheslav.testscalculator.exception.DivideByZeroException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    public void additionTest() {
        Number actual = calculatorService.addition(3, 6);//Тест на сложение: При сложении двух чисел a и b
        assertThat(actual).isEqualTo(9);              //Должны получить -  expected

        actual = calculatorService.addition(-3, 1);
        assertThat(actual).isEqualTo(-2);
    }

    @Test
    public void subtractionTest() {
        Number actual = calculatorService.subtraction(7, 3);   //Тест на вычитание: Из чисела a вычитаем b
        assertThat(actual).isEqualTo(4);                   //Должны получить -  expected

        actual = calculatorService.subtraction(-3, 1);
        assertThat(actual).isEqualTo(-4);
    }

    @Test
    public void multiplicationTest() {
        Number actual = calculatorService.multiply(5, 3);      //Тест на умножение: Умножение чисела a на b
        assertThat(actual).isEqualTo(15);                    //Должны получить -  expected

        actual = calculatorService.multiply(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }

    @Test
    public void divisionTest() {
        Number actual = calculatorService.divide(6, 3);         //Тест на деление: Деление чисела a на b
        assertThat(actual).isEqualTo(2);                     //Должны получить -  expected

        actual = calculatorService.divide(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }

    @Test                                                                //Тест деления чисел на ноль
    public void divisionNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(5, 0))
                .withMessage("На ноль делить нельзя!");


        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide(-7, 0))
                .withMessage("На ноль делить нельзя!");
    }
}