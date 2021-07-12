package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

//import com.recipetracker.finalversionrecipetracker.demo.model.Ingredients;
import lombok.Data;

import java.util.List;

@Data
public class RecipeResponseDto {
    private Long id;
    private String title;
    private String description;
    private String fileName;
    private String mediaType;
    private String downloadUri;
    private String username;
    private String country;
    private String cookingTime;
    private String calories;
    private boolean beef;
    private boolean fish;
    private boolean pork;
    private boolean lamb;
    private boolean vegan;
    private boolean vegetarian;
    private boolean spicy;
//    private List<Ingredients> ingredients;
}
