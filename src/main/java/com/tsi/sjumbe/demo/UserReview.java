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
    private String user_review;
    private int star_rating;
    private int reviewer_age;
    private  String reviewer_sex;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="film_film_id", insertable = false, nullable = false, updatable = false)
    private Film film;

    public UserReview(){}

    public UserReview(int film_film_id, String user_review, int star_rating, int reviewer_age, String reviewer_sex ){
        this.film_film_id =film_film_id;
        this.user_review = user_review;
        this.star_rating = star_rating;
        this.reviewer_age = reviewer_age;
        this.reviewer_sex = reviewer_sex;
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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {

        this.star_rating = star_rating;
    }

    public int getReviewer_age() {
        return reviewer_age;
    }

    public void setReviewer_age(int reviewer_age) {
        this.reviewer_age = reviewer_age;
    }

    public String getReviewer_sex() {
        return reviewer_sex;
    }

    public void setReviewer_sex(String reviewer_sex) {
        this.reviewer_sex = reviewer_sex;
    }
}
