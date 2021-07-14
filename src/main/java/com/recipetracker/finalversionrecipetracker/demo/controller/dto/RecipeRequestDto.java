package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

//import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
//import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
//import com.recipetracker.finalversionrecipetrackertracker.demo.model.Ingredient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecipeRequestDto {
    private Long id;
    private String title;
    private String username;
    private String userCountry;
    private String description;
    private MultipartFile file;
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
    private boolean poultry;
    private List<IngredientRequestDto> ingredients;
//    private List<Direction> directions;

    
}

