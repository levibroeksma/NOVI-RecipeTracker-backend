package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

public class RecipeDto {
    public long id;
    public String title;
    public String description;
    public boolean isBeef;
    private MultipartFile file;

//    public static RecipeDto fromRecipe (Recipe recipe) {
//        var dto = new RecipeDto();
//        dto.id = recipe.getId();
//        dto.title = recipe.getTitle();
//        dto.description = recipe.getDescription();
//        dto.isBeef = recipe.isBeef();
//        dto.file = recipe.getFile;
//        return dto;
//    }
//
//    public static Recipe toRecipe (RecipeDto recipeDto) {
//        var recipe = new Recipe();
//        recipe.setId(recipeDto.getId);
//        return recipe;
//    }
}
