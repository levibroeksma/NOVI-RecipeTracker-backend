package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Recipe, Long> {

}
