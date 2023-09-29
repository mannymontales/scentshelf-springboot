package com.app.scentshelf.utility;

import java.util.List;

import com.app.scentshelf.models.UserReviewPOJO;

public class ReviewsWrapper {
    
    private List<UserReviewPOJO> data;

    public List<UserReviewPOJO> getData() {
        return data;
    }

    public void setData(List<UserReviewPOJO> data) {
        this.data = data;
    }
}
