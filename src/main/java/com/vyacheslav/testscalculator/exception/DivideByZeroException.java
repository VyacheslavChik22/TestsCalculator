package com.vyacheslav.testscalculator.exception;

public class DivideByZeroException extends IllegalArgumentException {
    public DivideByZeroException(String message){
        super(message);
    }
}