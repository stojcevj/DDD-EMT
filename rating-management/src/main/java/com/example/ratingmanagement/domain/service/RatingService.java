package com.example.ratingmanagement.domain.service;

import com.example.ratingmanagement.domain.model.Rating;
import com.example.ratingmanagement.domain.model.RatingID;
import com.example.ratingmanagement.domain.service.form.RatingForm;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    Optional<Rating> addRating(RatingForm c);
    void deleteRating(RatingID id);
    List<Rating> findAll();
    Optional<Rating> findById(RatingID id);
}
