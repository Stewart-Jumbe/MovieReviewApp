package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Actor;
import com.tsi.sjumbe.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private Actor actor = new Actor();
    private Set<Film> testFilmSet= new HashSet<>();

    @Test
    public void test_constructor(){

        assertTrue(actor instanceof Actor,"Its not an instance of Language");
    }

    @Test
    public void test_getFirstName(){
        actor.setFirst_name("firstname");
        assertEquals("firstname",actor.getFirst_name(),"Get/Set FirstName method is not working");
    }

    @Test
    public void test_getLastName(){
        actor.setLast_name("lastname");
        assertEquals("lastname",actor.getLast_name(),"Get/Set LastNameMethod is not working");
    }


    @Test
    public void test_getActor_id(){
        actor.setActor_id(1);
        assertEquals(1,actor.getActor_id(),"Get/Set Actor_id method is not working" );
    }

    @Test
    public void test_getActorSet(){
        testFilmSet.add(new Film(
                "test title",
                "test description",
                "test rating",
                2001,
                1,
                1));
        actor.setFilm(testFilmSet);
        assertEquals(testFilmSet,actor.getFilm(),"Get/Set Film method is not working");
    }



}
