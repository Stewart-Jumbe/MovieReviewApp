package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="userreview")
public class UserReview {

    //Linking our primary key in java to mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_review_id;


    //Setting up many to one with film category
    @ManyToOne
    @JoinColumn(name ="film_id",insertable = false,nullable = false,updatable = false)
    private Film film;

    //Attributes//
    private String userReview;
    private int film_id;


    //Empty constructor
    public UserReview(){

    }

    //General Constructor
    public UserReview(String userReview, int film_id){
        this.userReview = userReview;
        this.film_id = film_id;
    }

    //Getters and Setters
    public int getUser_review_id() {
        return user_review_id;
    }

    public void setUser_review_id(int user_review_id) {
        this.user_review_id = user_review_id;
    }


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }
//Need to add Many to one relationship with film table




}
