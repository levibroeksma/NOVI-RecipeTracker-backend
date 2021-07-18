package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

//import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecipeRequestDto {
    public Long id;
    public String title;
    public String username;
    public String userCountry;
    public String description;
    public MultipartFile file;
    public String country;
    public String cookingTime;
    public String calories;
    public boolean beef;
    public boolean fish;
    public boolean pork;
    public boolean lamb;
    public boolean vegan;
    public boolean vegetarian;
    public boolean spicy;
    public boolean poultry;
    public String ingredients;
    public String directions;
}

