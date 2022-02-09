package com.tsi.sjumbe.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int actor_id;

    //Attributes
    private String first_Name;
    private String last_Name;


    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private Set<Film> films = new HashSet<>();

    //Empty Constructor
    public Actor(){

    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
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
