package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import com.recipetracker.finalversionrecipetracker.demo.requests.DirectionsRequest;

import java.util.List;

public interface DirectionsService {

    List<Direction> getAllDirections ();
    Direction getDirections(Long id);
    Direction saveDirections(Direction direction);
    void deleteDirections(Long id);
    Direction addDirections(DirectionsRequest directionsRequest);
    List<Direction> getDirectionsByRecipeId (Long id);
}