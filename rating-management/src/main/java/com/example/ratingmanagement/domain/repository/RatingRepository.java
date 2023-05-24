package com.example.ratingmanagement.domain.repository;

import com.example.ratingmanagement.domain.model.Rating;
import com.example.ratingmanagement.domain.model.RatingID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingID> {
}
