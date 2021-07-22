package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;

import java.util.List;

public interface IngredientsService {
    List<Ingredient> getAllIngredients ();
    Ingredient getIngredients(Long id);
    Ingredient saveIngredients(Ingredient ingredient);
    void deleteIngredients(Long id);
    Ingredient addIngredients(IngredientsRequest ingredientsRequest);
}