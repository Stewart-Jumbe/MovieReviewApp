package com.tsi.sjumbe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int category_id;

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
}