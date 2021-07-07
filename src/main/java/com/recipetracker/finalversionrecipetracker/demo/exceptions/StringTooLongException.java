package com.recipetracker.finalversionrecipetracker.demo.exceptions;

public class StringTooLongException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public StringTooLongException() {
        super();
    }
    public StringTooLongException(String message) {
        super(message);
    }

}
