package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Film;
import com.tsi.sjumbe.demo.Language;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest {

    private Language language= new Language();
   // private Set<Film>film = new HashSet<Film>()

    @Test
    public void test_constructor(){
        assertTrue(language instanceof Language,"Its not an instance of Language");
    }


    private Set<Film>filmSet = new HashSet<>();
    @Test
    public void test_getName(){
        language.setName("testname");
        assertEquals("testname",language.getName(),"Get Name method is not working");
    }

    @Test
    public void test_GetFilm(){
        filmSet.add(new Film("test title",
                "test description",
                "test rating",
                2001,
                1,
                1));
        ;
    }


    @Test
    public void test_getLanguage_id(){
        language.setLanguage_id(9);
        assertEquals(9,language.getLanguage_id(),"Get Method is not working");
    }





}
