package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name ="userreview")
public class UserReview implements Serializable {

    //Linking our primary key in java to mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_review_id;

    //Attributes//
    private String userReview;
    private int film_film_id;

    //Setting up many to one with film category
    @ManyToOne
    @JoinColumn(name ="film_film_id",insertable = false,nullable = false,updatable = false)
    private Film film;


    //Empty constructor
    public UserReview(){

    }

    //General Constructor
    public UserReview(String userReview, int film_id){
        this.userReview = userReview;
        this.film_film_id = film_film_id;
    }

    //Getters and Setters
    public int getUser_review_id() {
        return user_review_id;
    }

    public void setUser_review_id(int user_review_id) {
        this.user_review_id = user_review_id;
    }

    public int getFilm_film_id() {
        return film_film_id;
    }

    public void setFilm_film_id(int film_film_id) {
        this.film_film_id = film_film_id;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }
//Need to add Many to one relationship with film table


    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
