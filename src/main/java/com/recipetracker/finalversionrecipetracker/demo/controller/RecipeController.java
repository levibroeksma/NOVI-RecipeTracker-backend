package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeRequestDto;
import com.recipetracker.finalversionrecipetracker.demo.controller.dto.RecipeResponseDto;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "api/recipes")
@CrossOrigin
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("")
    public ResponseEntity<Object> getRecipes() {
        Iterable<Recipe> files = recipeService.getFiles();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/{id}/fileName")
    public ResponseEntity downloadFile(@PathVariable("id") Long id) {
        Resource resource = recipeService.downloadFile(id);
        String fileName = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileName))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecipeInfo(@PathVariable long id) {
        RecipeResponseDto response = recipeService.getFileById(id);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadRecipe( RecipeRequestDto recipeRequestDto) {
        try {
            long newId = recipeService.uploadFile(recipeRequestDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newId).toUri();

            return ResponseEntity.created(location).body(location);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}