package com.recipetracker.finalversionrecipetracker.demo.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super();
    }
    public BadRequestException(String msg) {
        super(msg);
    }
}