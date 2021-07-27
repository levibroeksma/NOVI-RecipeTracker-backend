package com.recipetracker.finalversionrecipetracker.demo.controller;

import com.recipetracker.finalversionrecipetracker.demo.model.Review;
import com.recipetracker.finalversionrecipetracker.demo.requests.ReviewRequest;
import com.recipetracker.finalversionrecipetracker.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        var reviews = new ArrayList<Review>();
        var allReviews = reviewService.getAllReviews();

        for (Review review : allReviews) {
            reviews.add(review);
        }
        return reviews;
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable("id") Long id) {
        var review = reviewService.getReview(id);
        return review;
    }

    @GetMapping("{id}/reviews")
    public List<Review> getReviewsByRecipeId(@PathVariable("id") Long recipeId) {
        return reviewService.getReviewsByRecipeId(recipeId);
    }

    @PostMapping("")
    public Review addReview (@RequestBody ReviewRequest reviewRequest){
        return reviewService.addReview(reviewRequest);
    }

    @DeleteMapping({"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteReview(@PathVariable("id") Long id) throws IOException {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

}
