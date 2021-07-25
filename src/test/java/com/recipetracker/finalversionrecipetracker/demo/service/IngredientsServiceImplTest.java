package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Ingredient;
import com.recipetracker.finalversionrecipetracker.demo.repository.IngredientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class IngredientsServiceImplTest {

    @Mock
    IngredientsRepository ingredientsRepository;

    @InjectMocks
    private IngredientsServiceImpl ingredientsService;

    @Captor
    ArgumentCaptor<Ingredient> ingredientCaptor;

    @Test
    public void getIngredientsExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> ingredientsService.getIngredients(null));
    }

    @Test
    public void getAllIngredientsTest() {
        List<Ingredient> ingredientList = new ArrayList<>();

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        ingredient1.setName("Cheese");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);
        ingredient2.setName("Bread");

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(1L);
        ingredient3.setName("Milk");

        ingredientList.add(ingredient1);
        ingredientList.add(ingredient2);
        ingredientList.add(ingredient3);


        when(ingredientsRepository.findAll()).thenReturn(ingredientList);

        ingredientsService.getAllIngredients();

        verify(ingredientsRepository, times(1)).findAll();

        assertThat(ingredientList.size()).isEqualTo(3);
        assertThat(ingredientList.get(0)).isEqualTo(ingredient1);
        assertThat(ingredientList.get(1)).isEqualTo(ingredient2);
        assertThat(ingredientList.get(2)).isEqualTo(ingredient3);

    }

    @Test
    public void saveIngredientsTest() {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(1L);
        ingredient.setName("Cheese");

        ingredientsRepository.save(ingredient);

        verify(ingredientsRepository, times(1)).save(ingredientCaptor.capture());
        var ingredient1 = ingredientCaptor.getValue();
        assertThat(ingredient1.getId()).isEqualTo(1L);
        assertThat(ingredient1.getName()).isEqualTo("Cheese");
    }
}