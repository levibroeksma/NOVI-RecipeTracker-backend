package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

