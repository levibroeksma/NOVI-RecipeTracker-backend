package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Review;
import com.recipetracker.finalversionrecipetracker.demo.repository.ReviewRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
public class ReviewServiceImplTest {

    @Captor
    ArgumentCaptor<Review> reviewCaptor;

    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void deleteAll() {
        reviewRepository.deleteAll();
    }

    @Test
    public void getReviewExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> reviewService.getReview(null));
    }

    @Test
    public void addReviewTest() {
        Review review = new Review();

        review.setReview("heerlijk");
        review.setRecipeId(1L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");

        reviewRepository.save(review);

        verify(reviewRepository, times(1)).save(reviewCaptor.capture());

        var review1 = reviewCaptor.getValue();

        assertThat(review1.getReview()).isEqualTo("heerlijk");
        assertThat(review1.getRecipeId()).isEqualTo(1L);
        assertThat(review1.getStars()).isEqualTo(5);
        assertThat(review1.getUsername()).isEqualTo("user");
        assertThat(review1.getUserCountry()).isEqualTo("belgium");
    }

    @Test
    public void getAllReviewsTest() {
        List<Review> reviewList = new ArrayList<>();

        Review review1 = new Review();
        review1.setReview("Amazing");
        review1.setId(1L);
        review1.setUsername("user");
        review1.setStars(4);
        review1.setUserCountry("nigeria");
        review1.setRecipeId(1L);

        Review review2 = new Review();
        review2.setReview("Amazing");
        review2.setId(1L);
        review2.setUsername("user");
        review2.setStars(4);
        review2.setUserCountry("nigeria");
        review2.setRecipeId(1L);

        Review review3 = new Review();
        review3.setReview("Amazing");
        review3.setId(1L);
        review3.setUsername("user");
        review3.setStars(4);
        review3.setUserCountry("nigeria");
        review3.setRecipeId(1L);

        reviewList.add(review1);
        reviewList.add(review2);
        reviewList.add(review3);

        when(reviewRepository.findAll()).thenReturn(reviewList);
        reviewService.getAllReviews();

        verify(reviewRepository, times(1)).findAll();

        assertThat(reviewList.size()).isEqualTo(3);
    }

    @Test
    public void getReviewTest() {
        Review review = new Review();

        review.setReview("Amazing");
        review.setRecipeId(1L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");

        when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

        reviewService.getReview(1L);
    }

    @Test
    public void getReviewTest2(){
//      No review available since no review is created
        assertThrows(RecordNotFoundException.class, () -> reviewService.getReview(1L));
    }

    @Test
    public void getReviewsByRecipeIdTest() {
        Review review = new Review();

        review.setReview("delicious");
        review.setRecipeId(1L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");
        reviewRepository.save(review);
        List<Review> reviewList = reviewRepository.getReviewsByRecipeId(1L);
        // already 2 reviews for this recipe due to data.sql
        assertEquals("user", review.getUsername());
        assertEquals("belgium", review.getUserCountry());
        assertEquals(5, review.getStars());
        assertEquals(1001, review.getRecipeId());
        assertEquals("delicious", review.getReview());
    }

}