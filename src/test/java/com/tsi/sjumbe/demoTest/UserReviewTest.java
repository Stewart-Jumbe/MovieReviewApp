package com.tsi.sjumbe.demoTest;

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
    void getUser_review_id() {
        newTestReview.setUser_review_id(1);
        assertEquals(1, newTestReview.getUser_review_id(),"Get/Set User Review method is not working");
    }

    @Test
    void getFilm_film_id() {
    }

    @Test
    void getUser_review() {
    }

    @Test
    void getFilm() {
    }

    @Test
    void getStar_rating() {
    }

    @Test
    void getReviewer_age() {
    }

    @Test
    void getReviewer_sex() {
    }
}