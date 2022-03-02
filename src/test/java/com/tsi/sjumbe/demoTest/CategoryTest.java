package com.tsi.sjumbe.demoTest;


import com.tsi.sjumbe.demo.Category;
import com.tsi.sjumbe.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {


    private Category category = new Category();
    private Film film;
    private Set<Film>testFilm = new HashSet<Film>();

    @Test
    public void test_constructor(){

        assertTrue(category instanceof Category,"Its not an instance of Language");
    }

    @Test
    public void test_getFirstName(){
        category.setName("categoryname");
        assertEquals("categoryname",category.getName(),"Get/Set Name method is not working");
    }

    @Test
    public void test_getCatagory_id(){
        category.setCategory_id(1);
        assertEquals(1,category.getCategory_id(),"Get/Set Actor_id method is not working" );
    }

    @Test
    public void test_SetFilm(){
        testFilm.add(new Film("test title",
                "test description",
                "test rating",
                2001,
                1,
                1));
        category.setFilm(testFilm);
        assertEquals(testFilm,category.getFilm(),"Set film is not working");}

        @Test
        public void test_GetFilm(){
            testFilm.add(new Film("test title",
                    "test description",
                    "test rating",
                    2001,
                    1,
                    1));
            category.setFilm(testFilm);
            assertEquals(category.getFilm(),testFilm,"Get film is not working");
    }

}
