package com.recipetracker.finalversionrecipetracker.demo.exceptions;

public class FileToLargeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public FileToLargeException() {
        super();
    }
    public FileToLargeException(String msg) {
        super(msg);
    }
}
