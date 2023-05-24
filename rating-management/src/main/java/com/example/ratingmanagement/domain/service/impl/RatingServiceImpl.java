package com.example.ratingmanagement.domain.service.impl;

import com.example.ratingmanagement.domain.model.Rating;
import com.example.ratingmanagement.domain.model.RatingID;
import com.example.ratingmanagement.domain.repository.RatingRepository;
import com.example.ratingmanagement.domain.service.RatingService;
import com.example.ratingmanagement.domain.service.form.RatingForm;
import com.example.sharedkernel.domain.valueobjects.Rate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Optional<Rating> addRating(RatingForm c) {
        Rating rating = Rating.build(Rate.of(c.rating));
        return Optional.of(ratingRepository.saveAndFlush(rating));
    }

    @Override
    public void deleteRating(RatingID id) {
        ratingRepository.deleteById(id);
    }

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> findById(RatingID id) {
        return ratingRepository.findById(id);
    }
}
