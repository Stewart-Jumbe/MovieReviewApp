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
    private Set<Film>filmSetList = new HashSet<>();

    @Test
    public void test_constructor(){
        assertTrue(language instanceof Language,"Its not an instance of Language");
    }


    @Test
    public void test_getName(){
        language.setName("testname");
        assertEquals("testname",language.getName(),"Get Name method is not working");
    }

    @Test
    public void test_GetFilm(){

        //Adding film to created Hashset
        filmSetList.add(new Film("test title",
                "test description",
                "test rating",
                2001,
                1,
                1));

        language.setFilm(filmSetList);
        assertEquals(filmSetList,language.getFilm());
    }


    @Test
    public void test_getLanguage_id(){
        language.setLanguage_id(9);
        assertEquals(9,language.getLanguage_id(),"Get Method is not working");
    }





}
