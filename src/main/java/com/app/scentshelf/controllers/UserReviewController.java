package com.app.scentshelf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.scentshelf.models.UserReviewPOJO;
import com.app.scentshelf.services.UserReviewService;
import com.app.scentshelf.utility.ReviewsWrapper;

@RestController
@RequestMapping("/api/review")
@CrossOrigin
public class UserReviewController {
    
    UserReviewService service;

    @Autowired
    UserReviewController(UserReviewService service) {
        this.service = service;
    }

    @GetMapping()
    public List<UserReviewPOJO> getTestData() throws Exception {
        ReviewsWrapper reviewsWrapper = service.getTestData();
        return reviewsWrapper.getData();
    }
}
