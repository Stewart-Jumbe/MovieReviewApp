package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "userreview")
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_review_id;
    private int film_film_id;
    private String userreview;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="film_film_id", insertable = false, nullable = false, updatable = false)
    private Film film;

    public UserReview(){}

    public UserReview(String userreview, int film_film_id){
        this.film_film_id =film_film_id;
        this.userreview = userreview;}

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

    public String getUserreview() {
        return userreview;
    }

    public void setUserreview(String userreview) {
        this.userreview = userreview;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
