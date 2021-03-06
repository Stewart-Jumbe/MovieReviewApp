package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userreview")
public class UserReview implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_review_id;
    private int film_film_id;
    private String user_review;
    private int star_rating;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="film_film_id", insertable = false, nullable = false, updatable = false)
    private Film film; // No need for getters and setters for film

    public UserReview(){}

    public UserReview(int film_film_id, String user_review, int star_rating){
        this.film_film_id =film_film_id;
        this.user_review = user_review;
        this.star_rating = star_rating;
//
    }

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

    public String getUser_review() {
        return user_review;
    }

    public void setUser_review(String user_review) {
        this.user_review = user_review;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {

        this.star_rating = star_rating;
    }

}
