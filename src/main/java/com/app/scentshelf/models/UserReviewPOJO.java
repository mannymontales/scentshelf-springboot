package com.app.scentshelf.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 * This class is not a annotated with entity because we dont need to persist this data in a 
 * database. We are just converting the JSON reviews to POJOS
 * This approach will not work with multiple fragrance reviews it only works with one, as
 * seenn in the service class
 * 
 * Also pojos should match the exact structure of the json, mismatch was 
 * giving me deserialization errors because i forgor the data [] property
 * 
 */
@Getter
@Setter
public class UserReviewPOJO {
    
    private String review_id;
    private String review_title;
    private String review_author;
    private String review_source;
    private String review_source_url;
    private String review_text;
    private int rating;
    private String review_datetime_utc;
    private String review_language;
    private List<String> photos;
}
