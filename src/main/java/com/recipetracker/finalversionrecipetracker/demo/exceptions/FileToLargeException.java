package com.recipetracker.finalversionrecipetracker.demo.exceptions;

public class FileToLargeException extends RuntimeException{
    public FileToLargeException() {
        super();
    }
    public FileToLargeException(String msg) {
        super(msg);
    }
}
