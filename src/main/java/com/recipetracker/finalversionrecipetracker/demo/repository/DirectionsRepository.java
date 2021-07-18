package com.recipetracker.finalversionrecipetracker.demo.repository;

import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectionsRepository extends JpaRepository<Direction, Long> {
    List<Direction> getDirectionsByRecipeId(Long id);
}