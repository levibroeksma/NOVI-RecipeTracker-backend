package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    List<Recipe> findAllByOrderByIdDesc();
    Recipe findRecipeById(Long recipeId);
}

