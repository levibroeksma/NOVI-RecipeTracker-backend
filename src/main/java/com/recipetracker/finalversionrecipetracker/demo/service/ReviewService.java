package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.model.Review;
import com.recipetracker.finalversionrecipetracker.demo.requests.ReviewRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<Review> getAllReviews ();
    Review getReview(Long id);
    void deleteReview(Long id);
    Review addReview(ReviewRequest reviewRequest);
    List<Review> getReviewsByRecipeId (Long id);
}
