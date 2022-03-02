package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeleteReviewStepsDef {
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

    int iD;
    UserReview savedReview;
    @Given("I want to delete an existing review")
    public void i_want_to_delete_an_existing_review() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        iD =10;

    }

    String actual;
    @When("An existing review is deleted")
    public void an_existing_review_is_deleted() {
        // Write code here that turns the phrase above into concrete actions
        actual = sakilaMicroserviceApplication.removeReviewByID(iD);

    }
    @Then("the review should be removed from the movie it was left on")
    public void the_review_should_be_removed_from_the_movie_it_was_left_on() {

        String expected ="Deleted";//response

        ArgumentCaptor<Integer>reviewArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(userReviewRepository).deleteById(reviewArgumentCaptor.capture());
        reviewArgumentCaptor.getValue();

        Assertions.assertEquals(expected, actual);
    }


}
