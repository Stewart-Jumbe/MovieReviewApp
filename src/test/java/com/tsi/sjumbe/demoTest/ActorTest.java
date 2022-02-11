package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Actor;
import com.tsi.sjumbe.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private Actor actor = new Actor();

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


}
