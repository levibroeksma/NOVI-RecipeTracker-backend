//package com.recipetracker.finalversionrecipetracker.demo.controller;
//
//import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
//import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
//import com.recipetracker.finalversionrecipetracker.demo.requests.DirectionsRequest;
//import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;
//import com.recipetracker.finalversionrecipetracker.demo.service.DirectionsService;
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
//@RequestMapping("directions")
//public class DirectionsController {
//    private final DirectionsService directionsService;
//
//    @Autowired
//    public DirectionsController(DirectionsService directionsService) {
//        this.directionsService = directionsService;
//    }
//
//    @GetMapping
//    public List<Direction> getAllDirections() {
//        var directions = new ArrayList<Direction>();
//        var allDirections = directionsService.getAllDirections();
//
//        for (Direction singelDirection : allDirections) {
//            directions.add(singelDirection);
//        }
//        return directions;
//    }
//
//    @GetMapping("/{id}")
//    public Direction getDirections(@PathVariable("id") Long id) {
//        var directions = directionsService.getDirections(id);
//        return directions;
//    }
//
//    @GetMapping("{id}/directions")
//    public List<Direction> getDirectionsByRecipeId(@PathVariable("id") Long recipeId) {
//        return directionsService.getDirectionsByRecipeId(recipeId);
//    }
//
//    @PostMapping
//    public Direction saveDirections(@RequestBody Direction directionOne) {
//        var directions = directionsService.saveDirections(directionOne);
//        return directions;
//    }
//
//    @PostMapping("save_directions")
//    public Direction addDirections (@RequestBody DirectionsRequest directionsRequest){
//        return directionsService.addDirections(directionsRequest);
//    }
//
//    @DeleteMapping({"{id}"})
//    public ResponseEntity<Object> deleteDirections(@PathVariable("id") Long id) throws IOException {
//        directionsService.deleteDirections(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}
