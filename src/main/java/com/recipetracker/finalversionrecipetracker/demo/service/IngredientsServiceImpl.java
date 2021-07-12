//package com.recipetracker.finalversionrecipetracker.demo.service;
//
//import com.recipetracker.finalversionrecipetracker.demo.exceptions.NotFoundException;
//import com.recipetracker.finalversionrecipetracker.demo.model.Ingredients;
//import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
//import com.recipetracker.finalversionrecipetracker.demo.repository.IngredientsRepository;
//import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
//import com.recipetracker.finalversionrecipetracker.demo.requests.IngredientsRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class IngredientsServiceImpl implements IngredientsService {
//
//    private IngredientsRepository ingredientsRepository;
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//
//    @Autowired
//    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
//        this.ingredientsRepository = ingredientsRepository;
//    }
//
//    public List<Object> getAllIngredientsByRecipeId(Long id) {
//        List<Ingredients> ingredientsList = ingredientsRepository.findAll();
//        List<Object> ingredientsByRecipe = new ArrayList<>();
//        for (int i = 0; i < ingredientsList.size(); i++) {
//            if (ingredientsList.get(i).getRecipeId()==id) ingredientsByRecipe.add(ingredientsList.get(i));
//        }
//        return ingredientsByRecipe;
//    }
//
//    @Override
//    public List<Ingredients> getAllIngredients() {
//        return ingredientsRepository.findAll();
//    }
//
//    @Override
//    public Ingredients getIngredients(Long id) {
//        var optionalIngredients = ingredientsRepository.findById(id);
//        if (optionalIngredients.isPresent()) {
//            return optionalIngredients.get();
//        } else throw new NotFoundException();
//    }
//
//    @Override
//    public Ingredients saveIngredients(Ingredients ingredients) {
//        return ingredientsRepository.save(ingredients);
//    }
//
//    @Override
//    public void deleteIngredients(Long id) {
//        ingredientsRepository.deleteById(id);
//    }
//
//    public Ingredients addIngredients(IngredientsRequest ingredientsRequest) {
//        Recipe recipe = recipeRepository.findRecipeId(ingredientsRequest.recipeId);
//
//        Ingredients ingredients = new Ingredients();
//        ingredients.setName(ingredientsRequest.name);
//        ingredients.setRecipeId(ingredientsRequest.recipeId);
//
//        return ingredientsRepository.save(ingredients);
//    }
//
//    @Override
//    public List<Ingredients> getIngredientsByRecipeId(Long id) {
//        return ingredientsRepository.getIngredientsByRecipeId(id);
//    }
//}
