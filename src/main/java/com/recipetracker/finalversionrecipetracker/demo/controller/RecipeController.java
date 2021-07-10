package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import com.recipetracker.finalversionrecipetracker.demo.service.FileStorageService;
import com.recipetracker.finalversionrecipetracker.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    FileStorageService fileStorageService;

    @Autowired
    @GetMapping
    public List<Recipe> getAllRecipes(){
//        Iterable<Recipe> files = fileStorageService.getFiles();
        return recipeService.getAllRecipes();

    };

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") Long id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Object> getRecipeById(@PathVariable("id") Long id) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTipAmsterdamById(@PathVariable("id") Long id) throws IOException {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
        String newTitle = recipeService.createRecipe(recipe);
        String newDescriptions = recipeService.createRecipe(recipe);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/recipes")
                .buildAndExpand(newTitle, newDescriptions).toUri();

        return ResponseEntity.created(location).build();
    }

}