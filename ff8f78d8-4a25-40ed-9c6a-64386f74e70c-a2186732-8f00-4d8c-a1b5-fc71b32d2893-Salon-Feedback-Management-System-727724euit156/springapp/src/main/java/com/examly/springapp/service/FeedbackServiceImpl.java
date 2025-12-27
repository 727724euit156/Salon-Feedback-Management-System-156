package com.examly.springapp.service;

import com.examly.springapp.model.Feedback;
import com.examly.springapp.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    
    @Autowired
    private FeedbackRepo feedbackRepo;
    
    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }
    
    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();
    }
    
    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepo.findById(id).orElse(null);
    }
    
    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {
        if (feedbackRepo.existsById(id)) {
            feedback.setId(id);
            return feedbackRepo.save(feedback);
        }
        return null;
    }
    
    @Override
    public void deleteFeedback(Long id) {
        feedbackRepo.deleteById(id);
    }
}