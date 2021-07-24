package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.repository.IngredientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class IngredientsServiceImplTest {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private IngredientsServiceImpl ingredientsServiceImpl;

    @Mock
    IngredientsRepository ingredientsRepositoryMock;

    @InjectMocks
    private IngredientsServiceImpl ingredientsService;

    @BeforeEach
    public void deleteAll() {
        ingredientsRepositoryMock.deleteAll();
    }
    @Test
    public void getIngredientsExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> ingredientsService.getIngredients(null));
    }

    @Test
    public void getAllIngredientsTest() {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(1001L);
        ingredient.setName("Cheese");
        ingredient.setRecipe(ingredient.getRecipe());
        List<Ingredient> ingredientList = ingredientsRepository.findAll();
        // Recipe already contains 32 ingredients
        assertEquals(33, ingredientList.size());
    }

    @Test
    public void saveIngredientsTest() {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(1001L);
        ingredient.setName("Cheese");
        ingredient.setRecipe(ingredient.getRecipe());
        ingredientsRepositoryMock.save(ingredient);
        List<Ingredient> ingredientList = ingredientsServiceImpl.getAllIngredients();

        assertEquals(33, ingredientList.size());
    }
}