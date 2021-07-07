package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Ingredients;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Recipe, Long> {
//    List<Ingredients> findById(Long id);

}
