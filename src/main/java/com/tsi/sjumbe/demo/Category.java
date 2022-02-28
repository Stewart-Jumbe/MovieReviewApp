package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name ="category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="category_id", insertable = false, nullable = false, updatable = false)
    private Film film; // No need for getters and setters for film

    //Attributes
    private String name;


    //Blank Constructor
    public Category(){

    }

    public Category(String name){
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}