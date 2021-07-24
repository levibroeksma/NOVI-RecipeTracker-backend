package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Direction;
import com.recipetracker.finalversionrecipetracker.demo.repository.DirectionsRepository;
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
public class DirectionsServiceImplTest {

    @Autowired
    private DirectionsRepository directionsRepository;

    @Autowired
    private DirectionsServiceImpl directionsServiceImpl;

    @Mock
    DirectionsRepository directionsRepositoryMock;

    @InjectMocks
    private DirectionsServiceImpl directionsService;

    @BeforeEach
    public void deleteAll() {
        directionsRepositoryMock.deleteAll();
    }

    @Test
    public void getDirectionsExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> directionsService.getDirections(null));
    }

    @Test
    public void getAllDirectionsTest() {
        Direction direction = new Direction();

        direction.setId(1001L);
        direction.setName("This is a description");
        direction.setRecipe(direction.getRecipe());
        List<Direction> directionList = directionsRepository.findAll();
        // Recipe already contains 18 directions
        assertEquals(19, directionList.size());
    }

    @Test
    public void saveDirectionsTest() {
        Direction direction = new Direction();

        direction.setId(1001L);
        direction.setName("Cheese");
        direction.setRecipe(direction.getRecipe());
        directionsRepositoryMock.save(direction);
        List<Direction> directionList = directionsServiceImpl.getAllDirections();
        // Recipe already contains 18 directions
        assertEquals(19, directionList.size());
    }
}