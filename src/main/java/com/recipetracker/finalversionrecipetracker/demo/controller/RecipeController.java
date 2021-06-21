package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/recipes")
    public ResponseEntity<List<Recipe>> getAllRecipes(@RequestParam(required = false) String title) {
        try{

            List<Recipe> recipes = new ArrayList<Recipe>();

            if (title == null) {
                recipeRepository.findAll().forEach(recipes::add);
            } else {
                recipeRepository.findByTitleContaining(title).forEach(recipes::add);
            }
            if (recipes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(recipes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") long id) {
        Optional<Recipe> recipeData = recipeRepository.findById(id);

        if (recipeData.isPresent()) {
            return new ResponseEntity<>(recipeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/recipes")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        try {
            Recipe _recipe = recipeRepository
                    .save(new Recipe(recipe.getTitle(), recipe.getDescription(), false));
            return new ResponseEntity<>(_recipe, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //

    @PutMapping("/recipe/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe) {
        Optional<Recipe> recipeData = recipeRepository.findById(id);

        if (recipeData.isPresent()) {
            Recipe _recipe = recipeData.get();
            _recipe.setTitle(recipe.getTitle());
            _recipe.setDescription(recipe.getDescription());
            _recipe.setBeef(recipe.isBeef());
            _recipe.setFish(recipe.isFish());
            _recipe.setLamb(recipe.isLamb());
            _recipe.setPork(recipe.isPork());
            _recipe.setVegan(recipe.isVegan());
            _recipe.setVegetarian(recipe.isVegetarian());
            _recipe.setSpicy(recipe.isSpicy());
            return new ResponseEntity<>(recipeRepository.save(_recipe), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<HttpStatus> deleteRecipe(@PathVariable("id") long id) {
        try {
            recipeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // FIND BY BOOLEANS

    @GetMapping("/recipes/beef")
    public ResponseEntity<List<Recipe>> findByBeef() {
        try {
            List<Recipe> recipes = recipeRepository.findByBeef(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/fish")
    public ResponseEntity<List<Recipe>> findByFish() {
        try {
            List<Recipe> recipes = recipeRepository.findByFish(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/lamb")
    public ResponseEntity<List<Recipe>> findByLamb() {
        try {
            List<Recipe> recipes = recipeRepository.findByLamb(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/pork")
    public ResponseEntity<List<Recipe>> findByPork() {
        try {
            List<Recipe> recipes = recipeRepository.findByPork(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/recipes/vegan")
    public ResponseEntity<List<Recipe>> findByVegan() {
        try {
            List<Recipe> recipes = recipeRepository.findByVegan(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/recipes/vegetarian")
    public ResponseEntity<List<Recipe>> findByVegetarian() {
        try {
            List<Recipe> recipes = recipeRepository.findByVegetarian(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/recipes/spicy")
    public ResponseEntity<List<Recipe>> findBySpicy() {
        try {
            List<Recipe> recipes = recipeRepository.findBySpicy(true);

            if (recipes.isEmpty()) {
                return new ResponseEntity<>(recipes, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
