package com.tsi.sjumbe.demoTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.tsi.sjumbe.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class menuCumberStepsDef {
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
                userReviewRepository);


    }



    Language saveLanguage;
    @Given("I want to add a new language")
    public void i_want_to_add_a_new_language() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        saveLanguage = new Language("Test Language");//Post req for mock db
    }

    String actual;
    @When("A new language is added")
    public void a_new_language_is_added() {
        // Write code here that turns the phrase above into concrete actions
        actual = sakilaMicroserviceApplication.addLanguage(saveLanguage.getName());

    }
    @Then("the language should be added to the language list and saved")
    public void the_language_should_be_added_to_the_language_list_and_saved() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";//response

        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());// throws exception if data not stored in mock db
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been added to mock DB");

    }

}
