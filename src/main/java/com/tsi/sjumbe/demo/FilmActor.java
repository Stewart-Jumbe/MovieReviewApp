package com.tsi.sjumbe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int actor_id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.TABLE)
    private int film_id;

    //empty constructor
    public FilmActor(){

    }

    public FilmActor(int actor_id, int film_id){
        this.actor_id =actor_id;
        this.film_id=film_id;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
