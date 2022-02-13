package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Actor;
import com.tsi.sjumbe.demo.Film;
import com.tsi.sjumbe.demo.UserReview;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmTest {

    private Film film = new Film("test title",
                            "test description",
                                "test rating",
                            2001,
                                1,
                            1);

    private Set<UserReview> testUserReviewSet = new HashSet<>();
    private Set<Actor> testActorSet = new HashSet<>();

    @Test
    public void test_GetTitle(){
        assertEquals("test title",film.getTitle(),"Get/Set title Method is not working");
    }

    @Test
    public void test_GetDescription(){;
        assertEquals("test description",film.getDescription(),"Get/Set Description method is not working");
    }

    @Test
    public void test_GetRating(){
        assertEquals("test rating",film.getRating(),"Get/Set rating method is not working");
    }

    @Test
    public void test_GetRelease_year(){
        assertEquals(2001,film.getRelease_year(),"Get/Set Release_year method not working");
    }

    @Test
    public void test_GetLength(){
        assertEquals("test rating",film.getRating(),"Get/Set Length method is not working");

    }

    @Test
    public void test_GetLanguage_id(){
        assertEquals(1,film.getLanguage_id());
    }

    @Test
    public void test_GetFilm_id(){
        film.setFilm_id(1);
        assertEquals(1,film.getFilm_id(),"Get/Set Film_id method is not working" );
    }

    @Test
    public void test_constructor(){

        assertTrue(film instanceof Film,"Its not an instance of Language");
    }

    @Test
    public void test_getUserReview(){
        testUserReviewSet.add(new UserReview(
                1,
                "Test Review",
                2,
                30,
                "male" ));
        film.setUserReview(testUserReviewSet);
        assertEquals(testUserReviewSet,film.getUserReview(),"Get/Set User Review method is not working");
    }

    @Test
    public void test_getActor(){
        testActorSet.add(new Actor("Rocco","Rain"));
        film.setActor(testActorSet);
        assertEquals(testActorSet,film.getActor(),"Get/Set Actor method is not working");

    }









}
