package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.model.User;
import org.springframework.core.io.Resource;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RecipeService {

    public abstract Collection<Recipe> getRecipes();
    List<Recipe> getAllRecipes();

    public abstract String createRecipe(Recipe recipe);

    Recipe getRecipe(Long id);

    Optional<Recipe> getRecipeById(Long id);

    void deleteRecipe(Long id);

//    void addRecipe(Recipe recipe);

    Resource downloadFile(Long id);

}
