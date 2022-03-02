package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddReviewStepsDef {
    private SakilaMicroserviceApplication sakilaMicroserviceApplication;

    @Mock
    private LanguageRepository languageRepository; // creating a fake version of the langRepo
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private UserReviewRepository userReviewRepository;

    @BeforeEach // creating an instance of our db with no data
    void Setup(){

        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        userReviewRepository =mock(UserReviewRepository.class);
        sakilaMicroserviceApplication = new SakilaMicroserviceApplication(languageRepository,
                filmRepository,
                actorRepository ,
                categoryRepository,
                userReviewRepository
                );


    }



    UserReview saveReview;
    @Given("I want to add a new review")
    public void i_want_to_add_a_new_review() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        saveReview = new UserReview(2,"That movie shook me",5);//Post req for mock db
    }

    String actual;
    @When("A new review is added")
    public void a_new_review_is_added() {
        // Write code here that turns the phrase above into concrete actions
       // actual = sakilaMicroserviceApplication.addLanguage(saveLanguage.getName());
        actual = sakilaMicroserviceApplication.addReview(
                saveReview.getFilm_film_id(),
                saveReview.getUser_review(),
                saveReview.getStar_rating());

    }
    @Then("the review should be added to the movie and saved")
    public void the_review_should_be_added_to_the_movie_and_saved() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";//response

        ArgumentCaptor<UserReview>reviewArgumentCaptor = ArgumentCaptor.forClass(UserReview.class);
        verify(userReviewRepository).save(reviewArgumentCaptor.capture());// throws exception if data not stored in mock db
        reviewArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"New Review data hasn't been added to mock DB");

    }



}
