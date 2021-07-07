package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import com.recipetracker.finalversionrecipetracker.demo.service.FileStorageService;
import com.recipetracker.finalversionrecipetracker.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
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

    @GetMapping
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    };

    @GetMapping("{id}/picturePath")
    public ResponseEntity downloadFile (@PathVariable Long id) {
        Resource resource = recipeService.downloadFile(id);
        String fileName = recipeService.getRecipe(id).getPicturePath();
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = \"" + fileName + "\"")
                .body(resource);
    }

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
//        String fileName = getRecipe(id).getPicturePath();
        recipeService.deleteRecipe(id);
//        fileStorageService.deleteFile(fileName);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
        String newTitle = recipeService.createRecipe(recipe);
        String newDescriptions = recipeService.createRecipe(recipe);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/recipes")
                .buildAndExpand(newTitle, newDescriptions).toUri();

        return ResponseEntity.created(location).build();
    }

//    public ResponseEntity<Object> addRecipe(
//                                         @RequestParam String title,
//                                         @RequestParam String description,
//                                         @RequestParam boolean beef,
//                                         @RequestParam MultipartFile picturePath) {
//        try {
//            fileStorageService.uploadFile(picturePath);
//
//            Recipe recipe = new Recipe();
//            recipe.setTitle(title);
//            recipe.setDescription(description);
//            recipe.setPicturePath(picturePath.getOriginalFilename());
//
//            recipeService.addRecipe(recipe);
//
//            return ResponseEntity.noContent().build();
//        } catch (Exception exception) {
//            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
//        }
//    }
}