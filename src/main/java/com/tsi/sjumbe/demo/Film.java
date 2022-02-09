package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity//notifys java that this is a table in our database
@Table(name ="film")
public class Film implements Serializable {

    @Id
    @GeneratedValue
    private int film_id;

    //Attributes
    private String title;
    private String description;
    private String rating;
    private int release_year;
    private float length;


    //blank constructor
    public Film(){

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

    public void setActors(Set<Actor> actors) {
        this.actor = actors;
    }

    public Film(String title,
                String description,
                String rating,
                int release_year,
                int length){

        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.rating = rating;
        this.length = length;
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

    public float getFilm_length() {
        return length;
    }

    public void setFilm_length(float film_length) {

        this.length = film_length;
    }
}
