package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Review;
import com.recipetracker.finalversionrecipetracker.demo.repository.ReviewRepository;
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
public class ReviewServiceImplTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @Mock
    ReviewRepository reviewRepositoryMock;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void deleteAll() {
        reviewRepositoryMock.deleteAll();
    }

    @Test
    public void getReviewExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> reviewService.getReview(null));
    }

    @Test
    public void addReviewTest() {
        Review review = new Review();

        review.setReview("heerlijk");
        review.setRecipeId(1001L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");
        reviewRepository.save(review);
        List<Review> reviewList = reviewServiceImpl.getAllReviews();
        // Already 8 reviews from data.sql imported
        assertEquals(9, reviewList.size());
    }

    @Test
    public void getAllReviewsTest() {
        Review review = new Review();

        review.setReview("heerlijk");
        review.setRecipeId(1001L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");
        reviewRepository.save(review);
        List<Review> reviewList = reviewRepository.findAll();
        // Already 8 reviews from data.sql imported
        assertEquals(9, reviewList.size());
    }

    @Test
    public void getReviewsByRecipeIdTest() {
        Review review = new Review();

        review.setReview("heerlijk");
        review.setRecipeId(1001L);
        review.setStars(5);
        review.setUsername("user");
        review.setUserCountry("belgium");
        reviewRepository.save(review);
        List<Review> reviewList = reviewRepository.getReviewsByRecipeId(1001L);
        // already 2 reviews for this recipe due to data.sql
        assertEquals(3, reviewList.size());
    }

}