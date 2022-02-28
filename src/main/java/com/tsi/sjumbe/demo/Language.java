package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name ="language")
public class Language implements Serializable {

    //Linking our primary key in java to mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;

    //Setting up many to many with language category and film class
    @OneToMany
    @JoinColumn(name ="language_id",insertable = false,updatable = false)
    @JsonIgnore
    private Set<Film> film;

    //Attributes
    private String name;

    ///empty constructor// needed to access DB
    public Language(){

    }



    public Language(String name){
        this.name = name; //associating called name with name in DB

    }
//Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int newID) {

    this.language_id = newID;
    }

    public Set<Film>getFilm(){
        return film;
    }

    public void setFilm(Set<Film> film) {
        this.film = film;
    }


}

