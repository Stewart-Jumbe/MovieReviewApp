package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.*;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
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
    private Set<Category> testCategorySet = new HashSet<>();
    private Language testLanguage = new Language();

    @Test
    public void test_Constructor(){
        assertTrue(film instanceof Film);
    }

    @Test
    public void test_GetTitle(){
        assertEquals("test title",film.getTitle(),"Get/Set title Method is not working");
    }

    @Test
    public void test_SetTitle(){
        film.setTitle("The greatest film");
        assertEquals("The greatest film",film.getTitle(),"Set title Method is not working");
    }

    @Test
    public void test_GetDescription(){;
        assertEquals("test description",film.getDescription(),"Get Description method is not working");
    }
    @Test
    public void test_SetDescription(){;
        film.setDescription("A film about people");
        assertEquals("A film about people",film.getDescription(),"Set Description method is not working");
    }


    @Test
    public void test_GetRating(){
        assertEquals("test rating",film.getRating(),"Get rating method is not working");
    }

    @Test
    public void test_SetRating(){
        film.setRating("Don't bother");
        assertEquals("Don't bother",film.getRating(),"Set rating method is not working");
    }

    @Test
    public void test_GetRelease_year(){
        assertEquals(2001,film.getRelease_year(),"Get Release_year method not working");
    }

    @Test
    public void test_SetRelease_year(){
        film.setRelease_year(1996);
        assertEquals(1996,film.getRelease_year(),"Its not working");
    }

    @Test
    public void test_GetLength(){
        assertEquals(1,film.getLength(),"Get Length method is not working");
    }

    @Test
    public void test_SetLength(){
        film.setLength(60.0f);
        assertEquals(60,film.getLength(),"Set Length method is not working");
    }



    @Test
    public void test_GetLanguage_id(){
        assertEquals(1,film.getLanguage_id(),"Get Language method is not working");
    }

    @Test
    public void test_SetLanguage_id(){
        film.setLanguage_id(5);
        assertEquals(5,film.getLanguage_id(),"Set Language method is not working");
    }


    @Test
    public void test_GetFilm_id(){
        assertEquals(0,film.getFilm_id(),"Set Film_id method is not working" );
    }

    @Test
    public void test_SetFilm_id(){
        film.setFilm_id(1);
        assertEquals(1,film.getFilm_id(),"Set Film_id method is not working" );
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
                2));
        film.setUserReview(testUserReviewSet);
        assertEquals(testUserReviewSet,film.getUserReview(),"Get/Set User Review method is not working");
    }

    @Test
    public void test_setUserReview(){
        film.setUserReview(testUserReviewSet);
        assertEquals(testUserReviewSet, film.getUserReview(),"The Set User Review method is not working");
    }

    @Test
    public void test_getActor(){
        testActorSet.add(new Actor("Rocco","Rain"));
        film.setActor(testActorSet);
        assertEquals(testActorSet,film.getActor(),"Get/Set Actor method is not working");

    }

    @Test
    public void testSet_Actor(){
        testActorSet.add(new Actor("Rocco","Rain"));
        film.setActor(testActorSet);
        assertEquals(film.getActor(), testActorSet, "The getActor method in Films is not working");
    }
    @Test
    public void test_GetLanguage(){
        assertEquals(null,film.getLanguage(),"Get Language method is not working");
    }

    @Test
    public void test_SetLanguage(){
        film.setLanguage(testLanguage);
        assertEquals(testLanguage, film.getLanguage(),"Set Language method is not working");
    }

    @Test
    public void test_SetCategory(){
        testCategorySet.add(new Category("Test Category"));
        film.setCategory(testCategorySet);
        assertEquals(testCategorySet,film.getCategory(), "Set Category is not working");
    }

    @Test
    public void test_GetCategory(){
        testCategorySet.add(new Category("Test Category"));
        film.setCategory(testCategorySet);
        assertEquals(film.getCategory(),testCategorySet, "Set Category is not working");
    }












}
