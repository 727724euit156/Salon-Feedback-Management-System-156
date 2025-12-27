package com.examly.springapp.service;

import com.examly.springapp.model.Rating;
import com.examly.springapp.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    
    @Autowired
    private RatingRepo ratingRepo;
    
    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }
    
    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }
    
    @Override
    public Rating getRatingById(Long id) {
        return ratingRepo.findById(id).orElse(null);
    }
    
    @Override
    public Rating updateRating(Long id, Rating rating) {
        if (ratingRepo.existsById(id)) {
            rating.setId(id);
            return ratingRepo.save(rating);
        }
        return null;
    }
    
    @Override
    public void deleteRating(Long id) {
        ratingRepo.deleteById(id);
    }
}