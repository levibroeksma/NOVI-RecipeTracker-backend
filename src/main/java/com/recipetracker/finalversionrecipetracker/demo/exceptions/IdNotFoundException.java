package com.recipetracker.finalversionrecipetracker.demo.exceptions;

public class IdNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public IdNotFoundException (Long id) { super("Can't find recipe with id: " + id);}
}