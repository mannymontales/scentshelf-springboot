package com.app.scentshelf.services;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.app.scentshelf.utility.ReviewsWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserReviewService {
    
    public ReviewsWrapper getTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        InputStream is = new ClassPathResource("profumo_reviews.json").getInputStream();

        ReviewsWrapper reviewsWrapper = objectMapper.readValue(is, ReviewsWrapper.class);

        return reviewsWrapper;
    }

}
