package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LanguageTest {

    private Language language= new Language();


    @Test
    public void constructor_test(){
        assertTrue("Its not an instance of Language",language instanceof Language);
    }

//    @Test
//    public void getName_test(){
//        Langu
//        language.setName("testname");
//        assertEquals("testname",language.getName(),"getName method is not working");
//
//
//    }





}
