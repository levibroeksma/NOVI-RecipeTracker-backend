package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;
import com.recipetracker.finalversionrecipetracker.demo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    @Autowired
    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        var ingredients = new ArrayList<Ingredient>();
        var allIngredients = ingredientsService.getAllIngredients();

        for (Ingredient singleIngredient : allIngredients) {
            ingredients.add(singleIngredient);
        }
        return ingredients;
    }

    @GetMapping("/{id}")
    public Ingredient getIngredients(@PathVariable("id") Long id) {
        var ingredients = ingredientsService.getIngredients(id);
        return ingredients;
    }

    @GetMapping("{id}/ingredients")
    public List<Ingredient> getIngredientsByRecipeId(@PathVariable("id") Long recipeId) {
        return ingredientsService.getIngredientsByRecipeId(recipeId);
    }

    @PostMapping
    public Ingredient saveIngredients(@RequestBody Ingredient ingredientOne) {
        var ingredients = ingredientsService.saveIngredients(ingredientOne);
        return ingredients;
    }

    @PostMapping("saveingredients")
    public Ingredient addIngredients (@RequestBody IngredientsRequest ingredientsRequest){
        return ingredientsService.addIngredients(ingredientsRequest);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Object> deleteIngredients(@PathVariable("id") Long id) throws IOException {
        ingredientsService.deleteIngredients(id);
        return ResponseEntity.noContent().build();
    }
}