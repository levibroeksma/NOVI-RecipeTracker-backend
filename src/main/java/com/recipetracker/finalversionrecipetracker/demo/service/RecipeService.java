package com.recipetracker.finalversionrecipetracker.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeRequestDto;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeResponseDto;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.core.io.Resource;

public interface RecipeService {

    void init();
    Iterable<Recipe> getAllRecipes();
    RecipeResponseDto getFileById(long id);
    long uploadRecipe(RecipeRequestDto method1Dto) throws JsonProcessingException;
    void deleteFile(long id);
    void deleteRecipeById(Long id);
    Resource downloadFile(long id);

//    void getRecipe(Object o);
}