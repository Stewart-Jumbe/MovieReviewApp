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
    public void test_getUser_review_id() {
        newTestReview.setUser_review_id(1);
        assertEquals(1, newTestReview.getUser_review_id(),"Get/Set User Review method is not working");
    }

    @Test
    public void test_getFilm_film_id() {
        assertEquals(2,newTestReview.getFilm_film_id(),"Get/Set Film_film_id method is not working");
    }

    @Test
    public void test_getUser_review() {
        assertEquals("test review", newTestReview.getUser_review(), "Get/Set user_review method is not working");
    }


    @Test
    public void test_getStar_rating() {
        assertEquals(5,newTestReview.getStar_rating(),"Get/Set star rating is not working");
    }

    @Test
    public void test_getReviewer_age() {
        assertEquals(45,newTestReview.getReviewer_age(),"Get/Set Reviewer age method is not working");
    }

    @Test
    public void test_getReviewer_sex() {
        assertEquals("female",newTestReview.getReviewer_sex(), "Get/Set Reviewer sex is not working");
    }
}