package com.vyacheslav.testscalculator.controller;

import com.vyacheslav.testscalculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome() {
        return calculatorService.welcome();
    }

    @GetMapping("/plus")
    public String addition(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Ошибка передачи параметров";
        } else {
            return buildString(a, b, calculatorService.addition(a, b), "+");
        }
    }

    @GetMapping("/minus")
    public String subtraction(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Ошибка передачи параметров";
        } else {
            return buildString(a, b, calculatorService.subtraction(a, b), "-");
        }
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Ошибка передачи параметров";
        } else {
            return buildString(a, b, calculatorService.multiply(a, b), "*");
        }
    }

    @GetMapping("/divide")
    public String division(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null || b == null) {
            return "Ошибка передачи параметров";
        }
        return buildString(a, b, calculatorService.divide(a, b), "/");

    }

    private String buildString(float a,
                               float b,
                               float result,
                               String operation) {
        return String.format("%.1f %s %.1f = %.1f", a, operation, b, result);
    }
}
