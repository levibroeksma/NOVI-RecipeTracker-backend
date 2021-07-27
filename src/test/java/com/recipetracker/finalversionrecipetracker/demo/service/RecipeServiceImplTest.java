package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.FileStorageException;
import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {

    @Captor
    ArgumentCaptor<Recipe> recipeCaptor;

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    @Test
    public void getRecipeExceptionTest() {
        // recipe with ID 2000 does not exist
        assertThrows(RecordNotFoundException.class, () -> recipeService.getFileById(2000L));
    }

    @Test
    public void initTest() {
        assertThrows(RuntimeException.class, () -> recipeService.init());
    }

    @Test
    public void getAllRecipesTest() {
        List<Recipe> testRecipes = new ArrayList<>();

        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setTitle("Titel");
        recipe1.setDescription("test");
        recipe1.setUsername("user");
        recipe1.setUserCountry("belgium");
        recipe1.setCountry("netherlands");
        recipe1.setCalories("45");
        recipe1.setFileName("habaneros.jpeg");

        Recipe recipe2 = new Recipe();
        recipe2.setId(1L);
        recipe2.setTitle("Titel");
        recipe2.setDescription("test");
        recipe2.setUsername("user");
        recipe2.setUserCountry("belgium");
        recipe2.setCountry("netherlands");
        recipe2.setCalories("45");
        recipe2.setFileName("habaneros.jpeg");

        testRecipes.add(recipe1);
        testRecipes.add(recipe2);

        when(recipeRepository.findAllByOrderByIdDesc()).thenReturn(testRecipes);

        recipeService.getAllRecipes();

        verify(recipeRepository, times(1)).findAllByOrderByIdDesc();

        assertThat(testRecipes.size()).isEqualTo(2);
        assertThat(testRecipes.get(0)).isEqualTo(recipe2);
        assertThat(testRecipes.get(1)).isEqualTo(recipe1);
    }

    @Test
    public void getFileByIdTest() {
        Recipe recipe = new Recipe();

        recipe.setId(1001L);

        when(recipeRepository.findById(1001L)).thenReturn(Optional.of(recipe));
        recipeService.getFileById(1001L);
    }

    @Test
    public void uploadRecipeTest() {
        Recipe recipe = new Recipe();

        recipe.setTitle("Recipe");
        recipe.setDescription("Description of recipe");
        recipe.setFileName("habaneros.jpeg");
        recipe.setCookingtime("45");
        recipe.setCalories("400");
        recipe.setBeef(false);
        recipe.setFish(false);
        recipe.setCountry("zimbabwe");
        recipe.setId(1L);
        recipe.setLamb(false);
        recipe.setVegan(false);
        recipe.setVegetarian(true);
        recipe.setUsername("user");
        recipe.setUserCountry("netherlands");
        recipe.setSpicy(false);
        recipe.setPork(false);
        recipe.setPoultry(false);

        recipeRepository.save(recipe);

        verify(recipeRepository, times(1)).save(recipeCaptor.capture());
        var recipe1 = recipeCaptor.getValue();

        assertThat(recipe1.getTitle()).isEqualTo("Recipe");
        assertThat(recipe1.getDescription()).isEqualTo("Description of recipe");
        assertThat(recipe1.getFileName()).isEqualTo("habaneros.jpeg");
        assertThat(recipe1.isBeef()).isEqualTo(false);
        assertThat(recipe1.isLamb()).isEqualTo(false);
        assertThat(recipe1.isVegan()).isEqualTo(false);
        assertThat(recipe1.isPork()).isEqualTo(false);
        assertThat(recipe1.isSpicy()).isEqualTo(false);
        assertThat(recipe1.isPoultry()).isEqualTo(false);
        assertThat(recipe1.isVegetarian()).isEqualTo(true);
        assertThat(recipe1.isFish()).isEqualTo(false);
        assertThat(recipe1.getCountry()).isEqualTo("zimbabwe");
        assertThat(recipe1.getUsername()).isEqualTo("user");
        assertThat(recipe1.getUserCountry()).isEqualTo("netherlands");
    }

    @Test
    public void deleteRecipeById() {
        Recipe recipe = new Recipe();

        recipe.setTitle("Recipe");
        recipe.setDescription("Description of recipe");
        recipe.setFileName("habaneros.jpeg");
        recipe.setCookingtime("45");
        recipe.setCalories("400");
        recipe.setBeef(false);
        recipe.setFish(false);
        recipe.setCountry("zimbabwe");
        recipe.setId(1L);
        recipe.setLamb(false);
        recipe.setVegan(false);
        recipe.setVegetarian(true);
        recipe.setUsername("user");
        recipe.setUserCountry("netherlands");
        recipe.setSpicy(false);
        recipe.setPork(false);
        recipe.setPoultry(false);

        recipeRepository.delete(recipe);

        recipeService.deleteRecipeById(1L);
        verify(recipeRepository, times(1)).delete(recipe);
    }

}
