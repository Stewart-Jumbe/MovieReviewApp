package com.tsi.sjumbe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserReview {

    //Linking our primary key in java to mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_review_id;

    //Attributes//
    String userReview;

    //Empty constructor
    public UserReview(){

    }

    //General Constructor
    public UserReview(String userReview){
        this.userReview = userReview;

    }

    //Need to add Many to one relationship with film table




}
