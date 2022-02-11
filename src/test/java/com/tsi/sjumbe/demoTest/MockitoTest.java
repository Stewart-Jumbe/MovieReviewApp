//package com.tsi.sjumbe.demoTest;
//import com.tsi.sjumbe.demo.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)//inhereting characteristics needed to use mockito
//public class MockitoTest {
//    private SakilaMicroserviceApplication sakilaMicroserviceApplication;
//
//    @Mock
//    private LanguageRepository languageRepository; // creating a fake version of the langRepo
//    @Mock
//    private FilmRepository filmRepository;
//    @Mock
//    private ActorRepository actorRepository;
//    @Mock
//    private CategoryRepository categoryRepository;
//    @Mock
//    private UserReviewRepository userReviewRepository;
//
//    @BeforeEach // creating an instance of our db with no data
//    void Setup(){
//        sakilaMicroserviceApplication = new SakilaMicroserviceApplication(languageRepository,
//                filmRepository,
//                actorRepository,
//                categoryRepository,
//                userReviewRepository
//        );
//    }
//
//    ///Testing Post Request to addLanguage
//    @Test
//    public void testAddLanguage(){
//        Language saveLanguage = new Language("Test Language");//Post req for mock db
//        String expected = "save";//response
//        String actual = sakilaMicroserviceApplication.addLanguage(saveLanguage.getName());
//        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);//holds data ("test language" temporarily
//        //Verifying that repo has saved instance
//        verify(languageRepository).save(languageArgumentCaptor.capture());//
//        languageArgumentCaptor.getValue();
//        Assertions.assertEquals(expected,actual,"Data hasn't been added to mock DB");
//
//    }
//
////    @Test
////    public void testGetAllLanguages(){
////
////    }
//
//
//}
