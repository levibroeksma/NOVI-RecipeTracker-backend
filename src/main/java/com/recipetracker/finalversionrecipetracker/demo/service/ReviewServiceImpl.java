package com.recipetracker.finalversionrecipetracker.demo.service;

import com.recipetracker.finalversionrecipetracker.demo.exceptions.RecordNotFoundException;
import com.recipetracker.finalversionrecipetracker.demo.model.Recipe;
import com.recipetracker.finalversionrecipetracker.demo.model.Review;
import com.recipetracker.finalversionrecipetracker.demo.repository.RecipeRepository;
import com.recipetracker.finalversionrecipetracker.demo.repository.ReviewRepository;
import com.recipetracker.finalversionrecipetracker.demo.requests.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ReviewRepository reviewRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Object> getAllReviewsByRecipeId(Long id) {
        List<Review> reviewList = reviewRepository.findAll();
        List<Object> reviewByRecipe = new ArrayList<>();
        for (int i = 0; i < reviewList.size(); i++) {
            if (reviewList.get(i).getRecipeId()==id) reviewByRecipe.add(reviewList.get(i));
        }
        return reviewByRecipe;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReview(Long id) {
        var optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            return optionalReview.get();
        } else throw new RecordNotFoundException();
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review addReview(ReviewRequest reviewRequest) {
        Recipe recipe = recipeRepository.findRecipeById(reviewRequest.recipeId);

        Review review = new Review();
        review.setReview(reviewRequest.review);
        review.setRecipeId(reviewRequest.recipeId);
        review.setStars(reviewRequest.stars);
        review.setUsername(reviewRequest.username);
        review.setUserCountry(reviewRequest.userCountry);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewsByRecipeId(Long id) {
        return reviewRepository.getReviewsByRecipeId(id);
    }
}
