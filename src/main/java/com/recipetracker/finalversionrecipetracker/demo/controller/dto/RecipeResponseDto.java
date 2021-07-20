package com.recipetracker.finalversionrecipetracker.demo.controller.dto;

import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class RecipeResponseDto {
    public String title;
    public String description;
    public MultipartFile file;
    public String fileName;
    public String mediaType;
    public String downloadUri;
    public String username;
    public String userCountry;
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
    public List<Ingredient> ingredients;
    public List<Direction> directions;
}
