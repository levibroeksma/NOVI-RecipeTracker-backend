//package com.recipetracker.finalversionrecipetracker.demo.controller;
//
//import com.recipetracker.finalversionrecipetracker.demo.model.Ingredients;
//import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
//import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;
//import com.recipetracker.finalversionrecipetracker.demo.service.IngredientsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("ingredients")
//public class IngredientsController {
//
//    private final IngredientsService ingredientsService;
//
//    @Autowired
//    public IngredientsController(IngredientsService ingredientsService) {
//        this.ingredientsService = ingredientsService;
//    }
//
//    @GetMapping
//    public List<Ingredients> getAllIngredients() {
//        var ingredients = new ArrayList<Ingredients>();
//        var allIngredients = ingredientsService.getAllIngredients();
//
//        for (Ingredients ingredients : allIngredients) {
//            ingredients.add(ingredient);
//        }
//        return ingredients;
//    }
//
//    @GetMapping("/{id}")
//    public Ingredients getIngredients(@PathVariable("id") Long id) {
//        var ingredients = ingredientsService.getIngredients(id);
//        return ingredients;
//    }
//
//    @GetMapping("{id}/ingredients")
//    public List<Ingredients> getIngredientsByRecipeId(@PathVariable("id") Long recipeId) {
//        return ingredientsService.getIngredientsByRecipeId(recipeId);
//    }
//
//    @PostMapping
//    public Ingredients saveIngredients(@RequestBody Ingredients ingredientOne) {
//        var ingredients = ingredientsService.saveIngredients(ingredientOne);
//        return ingredients;
//    }
//
//    @PostMapping("saveingredients")
//    public Ingredients addIngredients (@RequestBody IngredientsRequest ingredientsRequest){
//        return ingredientsService.addIngredients(ingredientsRequest);
//    }
//
//    @DeleteMapping({"{id}"})
//    public ResponseEntity<Object> deleteIngredients(@PathVariable("id") Long id) throws IOException {
//        ingredientsService.deleteIngredients(id);
//        return ResponseEntity.noContent().build();
//    }
//}