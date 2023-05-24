package com.example.ratingmanagement.domain.service.form;

import lombok.Data;
import lombok.NonNull;

@Data
public class RatingForm {
    @NonNull
    public Integer rating;
}
