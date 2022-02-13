package com.tsi.sjumbe.demoTest;
import com.tsi.sjumbe.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)//inhereting characteristics needed to use mockito
public class MockitoTest {
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
        sakilaMicroserviceApplication = new SakilaMicroserviceApplication(languageRepository,
                filmRepository,
                actorRepository,
                categoryRepository,
                userReviewRepository
        );
    }

    ///Testing Post Request to addLanguage
    @Test
    public void test_AddLanguage(){
        Language saveLanguage = new Language("Test Language");//Post req for mock db
        String expected = "save";//response
        String actual = sakilaMicroserviceApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);//holds data ("test language" temporarily
        //Verifying that repo has saved instance
        verify(languageRepository).save(languageArgumentCaptor.capture());//
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been added to mock DB");

    }

    //Testing Post Request to addFilm
    @Test
    public void test_AddFilm(){
        Film saveFilm = new Film("Test Film I",
                "Film about testing",
                "Awesome",
                2022,
                120,
                1);
        String expected = "save";

        String actual = sakilaMicroserviceApplication.addFilm(
                saveFilm.getTitle(),
                saveFilm.getDescription(),
                saveFilm.getRating(),
                saveFilm.getRelease_year(),
                saveFilm.getLength(),
                saveFilm.getLanguage_id());

        ArgumentCaptor<Film>filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);//holds data ("test language" temporarily

        //Verifying that repo has saved instance
        verify(filmRepository).save(filmArgumentCaptor.capture());//

        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been added to mock DB");

    }
    //Testing Post Request to AddActor
    @Test
    public void tes_addActor(){
        Actor testActor = new Actor("Test","Name");

        String expected ="New actor saved";

        String actual = sakilaMicroserviceApplication.addActor(testActor.getFirst_name(),testActor.getLast_name());

        ArgumentCaptor<Actor>actorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Actor data hasn't been added to mock DB");

    }


}
