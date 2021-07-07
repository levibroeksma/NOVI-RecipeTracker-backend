package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    List<Recipe> findByTitleContaining(String title);
//    List<Recipe> findByBeef(boolean beef);
//    List<Recipe> findByCountry(String country);
//    List<Recipe> findByRecipeImage(byte[] recipeImage);
//    List<Recipe> findByFish(boolean fish);
//    List<Recipe> findByLamb(boolean lamb);
//    List<Recipe> findByPork(boolean pork);
//    List<Recipe> findByVegan(boolean vegan);
//    List<Recipe> findByVegetarian(boolean vegetarian);
//    List<Recipe> findBySpicy(boolean spicy);
    boolean existsById(Long id);
}
