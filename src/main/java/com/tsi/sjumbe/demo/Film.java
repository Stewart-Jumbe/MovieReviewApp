package com.tsi.sjumbe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//notifys java that this is a table in our database
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
