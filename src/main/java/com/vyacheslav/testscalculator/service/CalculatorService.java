package com.vyacheslav.testscalculator.service;


import com.vyacheslav.testscalculator.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    public Integer addition(Integer a, Integer b) {
        return a + b;
    }

    public Integer subtraction(Integer a, Integer b) {
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {

        if (b == 0) { // если делимое равно нулю, то в консоли выводим ошибку-исключение

            throw new DivideByZeroException("На ноль делить нельзя!");

        }
        return a / b;
    }
}
