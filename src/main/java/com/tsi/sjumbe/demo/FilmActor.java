package com.tsi.sjumbe.demo;

import javax.persistence.*;

@Entity
@IdClass(Film.class)
public class FilmActor {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int actor_id;

    @Id
    @GeneratedValue
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
