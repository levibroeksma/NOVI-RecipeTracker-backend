package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;

public class RecipeDto {
    public long id;
    public String title;
    public String description;
    public boolean isBeef;
//    public boolean isFish;

    public static RecipeDto fromRecipe (Recipe recipe) {
        var dto = new RecipeDto();
        dto.id = recipe.getId();
        dto.title = recipe.getTitle();
        dto.description = recipe.getDescription();
        dto.isBeef = recipe.isBeef();
//        dto.isFish = recipe.isFish();
        return dto;
    }
}
