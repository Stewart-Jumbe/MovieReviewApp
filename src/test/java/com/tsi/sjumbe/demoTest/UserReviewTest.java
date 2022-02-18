package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Film;
import com.tsi.sjumbe.demo.UserReview;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserReviewTest {

    UserReview newTestReview = new UserReview(
            2,
            "test review",
            5,
            45,
            "female" );



    @Test
    public void test_UserReviewConstructor(){
        assertTrue(newTestReview instanceof UserReview);
    }



    @Test
    public void test_GetUser_review_id() {
        newTestReview.setUser_review_id(1);
        assertEquals(1, newTestReview.getUser_review_id(),"Get/Set User Review method is not working");
    }

    @Test
    public void test_GetFilm_film_id() {
        assertEquals(2,newTestReview.getFilm_film_id(),"Get Film_film_id method is not working");
    }

    @Test
    public void test_SetFilm_film_id() {
        newTestReview.setFilm_film_id(1);
        assertEquals(1,newTestReview.getFilm_film_id(),"Set Film_film_id method is not working");
    }


    @Test
    public void test_GetUser_review() {
        assertEquals("test review", newTestReview.getUser_review(), "Get/Set user_review method is not working");
    }

    @Test
    public void test_SetUser_review() {
        newTestReview.setUser_review("Amazing");
        assertEquals("Amazing", newTestReview.getUser_review(), "Set user_review method is not working");
    }


    @Test
    public void test_GetStar_rating() {
        assertEquals(5,newTestReview.getStar_rating(),"Get/Set star rating is not working");
    }

    @Test
    public void test_SetStar_rating() {
        newTestReview.setStar_rating(6);
        assertEquals(6,newTestReview.getStar_rating(),"Get/Set star rating is not working");
    }



    @Test
    public void test_GetReviewer_age() {
        assertEquals(45,newTestReview.getReviewer_age(),"Get/Set Reviewer age method is not working");
    }

    @Test
    public void test_SetReviewer_age() {
        newTestReview.setReviewer_age(77);
        assertEquals(77,newTestReview.getReviewer_age(),"Set Reviewer age method is not working");
    }

    @Test
    public void test_GetReviewer_sex() {
        assertEquals("female",newTestReview.getReviewer_sex(), "Get/Set Reviewer sex is not working");
    }

    @Test
    public void test_setReviewer_sex() {
        newTestReview.setReviewer_sex("Male");
        assertEquals("Male",newTestReview.getReviewer_sex(), "Set Reviewer sex is not working");
    }
}