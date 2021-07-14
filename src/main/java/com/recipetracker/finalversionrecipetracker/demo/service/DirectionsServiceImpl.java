//package com.recipetracker.finalversionrecipetracker.demo.service;
//
//import com.recipetracker.finalversionrecipetracker.demo.exceptions.NotFoundException;
//import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
//import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
//import com.recipetracker.finalversionrecipetracker.demo.repository.DirectionsRepository;
//import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
//import com.recipetracker.finalversionrecipetracker.demo.requests.DirectionsRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class DirectionsServiceImpl implements DirectionsService{
//
//    private DirectionsRepository directionsRepository;
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//
//    @Autowired
//    public DirectionsServiceImpl(DirectionsRepository directionsRepository) {
//        this.directionsRepository = directionsRepository;
//    }
//
//    public List<Object> getAllDirectionsByRecipeId(Long id) {
//        List<Direction> directionsList = directionsRepository.findAll();
//        List<Object> directionsByRecipe = new ArrayList<>();
//        for (int i = 0; i < directionsList.size(); i++) {
//            if (directionsList.get(i).getRecipeId()==id) directionsByRecipe.add(directionsList.get(i));
//        }
//        return directionsByRecipe;
//    }
//
//    @Override
//    public List<Direction> getAllDirections() {
//        return directionsRepository.findAll();
//    }
//
//    @Override
//    public Direction getDirections(Long id) {
//        var optionalDirections = directionsRepository.findById(id);
//        if (optionalDirections.isPresent()) {
//            return optionalDirections.get();
//        } else throw new NotFoundException();
//    }
//
//    @Override
//    public Direction saveDirections(Direction direction) {
//        return directionsRepository.save(direction);
//    }
//
//    @Override
//    public void deleteDirections(Long id) {
//        directionsRepository.deleteById(id);
//    }
//
//    public Direction addDirections(DirectionsRequest directionsRequest) {
//        Optional<Recipe> optionalRecipe = recipeRepository.findById(directionsRequest.id);
//        if (optionalRecipe.isPresent()) {
//            Recipe recipe = optionalRecipe.get();
//            Direction directions = new Direction();
//            directions.setName(directionsRequest.name);
//
//            directions.setRecipe(recipe);
//            recipe.getDirections().add(directions);
//            recipeRepository.save(recipe);
//            return directionsRepository.save(directions);
//        } else throw new NotFoundException();
//
//    }
//
//    @Override
//    public List<Direction> getDirectionsByRecipeId(Long id) {
//        return directionsRepository.getDirectionsByRecipeId(id);
//    }
//
//
//
//
//
//}
