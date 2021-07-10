package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.IdNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.NotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;

import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    Path uploads = Paths.get("./uploads");

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Collection<Recipe> getRecipes() {
        return null;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.getById(id);
    }


    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        if (!recipeRepository.existsById(id)) throw new IdNotFoundException(id);
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe;
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public String createRecipe(Recipe recipe){
        recipe.setTitle(recipe.getTitle());
        recipe.setDescription(recipe.getDescription());
        recipe.setLocation(recipe.getLocation());
        Recipe newRecipe = recipeRepository.save(recipe);
        return newRecipe.getTitle();
    }

    public Resource downloadFile(Long id) {
        Optional<Recipe> stored = recipeRepository.findById(id);

        if (stored.isPresent()) {
            String fileName = stored.get().getPicturePath();
            Path path = this.uploads.resolve(fileName);

            Resource resource = null;

            try {
                resource = new UrlResource(path.toUri());
                return resource;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            throw new NotFoundException();
        }
        return null;
    }

}