package com.tsi.sjumbe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int actor_id;

    //Attributes
    private String first_Name;
    private String last_Name;

    //Empty Constructor
    public Actor(){

    }

    public Actor(String first_Name, String last_Name){
        this.first_Name = first_Name;
        this.last_Name= last_Name;
    }

    public int getActor_id() {
        return actor_id;
    }


    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
}
