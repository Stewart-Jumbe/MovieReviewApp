package com.tsi.sjumbe.demoTest;
import com.tsi.sjumbe.demo.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    private Object Film;

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

    //Testing Post Request to AddReview
    @Test
    public void test_AddReview(){
        UserReview testReview = new UserReview(2,
                "test review",
                5,
                45,
                "female");

        String expected ="save";

        String actual = sakilaMicroserviceApplication.addReview(testReview.getFilm_film_id(),
                testReview.getUser_review(),
                testReview.getStar_rating(),
                testReview.getReviewer_age(),
                testReview.getReviewer_sex());

        ArgumentCaptor<UserReview>actorArgumentCaptor = ArgumentCaptor.forClass(UserReview.class);

        verify(userReviewRepository).save(actorArgumentCaptor.capture());

        actorArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Actor data hasn't been added to mock DB");

    }

    //Testing Delete request , to remove a review by ID
//    @Test
//    public void test_DeleteReview(){
//        UserReview testReview = new UserReview(2,
//                "test review",
//                5,
//                45,
//                "female");
//        userReviewRepository.save(testReview);
//        when(sakilaMicroserviceApplication.removeReviewByID(testReview.getUser_review_id()).thenReturn(null);
//
//    }


    //Get Mapping for listing All_languages
    @Test
    public void test_GetALLLanguages(){
            Language testLang1 = new Language("Kwaconda");
            List<Language> languageList = new ArrayList<>();
            languageList.add(testLang1);
            when(sakilaMicroserviceApplication.getAllLanguages()).
                    thenReturn(languageList);
            Assertions.assertEquals(languageList, sakilaMicroserviceApplication.getAllLanguages(), "Languages data was not saved to Mock DB.");
    }

    //Get Mapping for listing All_Films
    @Test
    public void test_GetALLFilms(){
        Film testFilm1 = new Film("test title",
                "test description",
                "test rating",
                2001,
                1,
                1);
        List<Film> expectedFilmList = new ArrayList<>();
        expectedFilmList.add(testFilm1);
        when(sakilaMicroserviceApplication.getAllFilms()).thenReturn(expectedFilmList);
        Assertions.assertEquals(expectedFilmList, sakilaMicroserviceApplication.getAllFilms(), "Films data was not saved to Mock DB.");
    }

    //Get Mapping for listing All_Films
    @Test
    public void test_GetFilmByID(){
        Film testFilm1 = new Film("test title",
                "test description",
                "test rating",
                2001,
                1,
                1);
        when(sakilaMicroserviceApplication.getFilmByID(testFilm1.getFilm_id())).thenReturn(Optional.of(testFilm1));
        Assertions.assertEquals(sakilaMicroserviceApplication.getFilmByID(testFilm1.getFilm_id()), Optional.of(testFilm1), "Films data was not saved to Mock DB.");
    }

    //Get Mapping for listing All_Actors
    @Test
    public void test_GetALLActors(){
        Actor testActor = new Actor("Jojo","Star");
        List<Actor> expectedActorList = new ArrayList<>();
        expectedActorList.add(testActor);
        when(sakilaMicroserviceApplication.getAllActors()).thenReturn(expectedActorList);
        Assertions.assertEquals(expectedActorList, sakilaMicroserviceApplication.getAllActors(), "Actors data was not saved to Mock DB.");
    }

    //Get Mapping for listing All_Categories
    @Test
    public void test_GetALLCategories(){
        Category testCategory = new Category("Other");
        List<Category> expectedCategoryList = new ArrayList<>();
        expectedCategoryList.add(testCategory);
        when(sakilaMicroserviceApplication.getAllCategories()).thenReturn(expectedCategoryList);
        Assertions.assertEquals(expectedCategoryList, sakilaMicroserviceApplication.getAllCategories(), "Categories data was not saved to Mock DB.");

    }

    //Get Mapping for listing All_Reviews
    @Test
    public void test_GetALLReviews(){
        UserReview testReview = new UserReview(
                2,
                "test review",
                5,
                45,
                "female");
        List<UserReview> expectedReviewList = new ArrayList<>();
        expectedReviewList.add(testReview);
        when(sakilaMicroserviceApplication.getAllReviews()).thenReturn(expectedReviewList);
        Assertions.assertEquals(expectedReviewList, sakilaMicroserviceApplication.getAllReviews(), "UserReview data was not saved to Mock DB.");

    }
    //added comment


}
