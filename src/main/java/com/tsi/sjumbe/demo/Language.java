package com.tsi.sjumbe.demo;

import com.fasterxml.jackson.annotation.JsonTypeId;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Language {



    //Linking our primary key in java to mysql
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int language_id;

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
}
