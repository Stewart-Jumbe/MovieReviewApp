package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.catalina.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity//notifys java that this is a table in our database
@Table(name ="film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int film_id;

    //Attributes
    private String title;
    private String description;
    private String rating;
    private int release_year;
    private float length;
    private int language_id;

    //Needed to add ManyToOne connection to get language information
    @ManyToOne
    @JoinColumn(name ="language_id", insertable = false, updatable = false)
    private Language language;

    //Needed to add OnetoMany connection to get userreview table
    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private Set<UserReview>userReview = new HashSet<>();



    public Film(String title,
                String description,
                String rating,
                int release_year,
                float length,
                int language_id){

        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.rating = rating;
        this.length = length;
        this.language_id = language_id;
    }




    //blank constructor
    public Film(){

    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();

    public Set<Actor> getActor() {
        return actor;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }


    public void setFilm_id(int film_id){
       this.film_id = film_id;
    }

    public int getFilm_id() {
        return film_id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {

        this.rating = rating;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {

        this.release_year = release_year;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


        public Set<UserReview> getUserReview() {
        return userReview;
    }

    public void setUserReview(Set<UserReview> userReview) {
        this.userReview = userReview;
    }
}
