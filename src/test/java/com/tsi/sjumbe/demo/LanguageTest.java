package com.tsi.sjumbe.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LanguageTest {

    private Language language= new Language();


    @Test
    public void test_constructor(){
        assertTrue("Its not an instance of Language",language instanceof Language);
    }

    @Test
    public void test_getName(){
        language.setName("testname");
        assertEquals("testname",language.getName());


    }


    @SpringBootTest
    static
    class SakilaMicroserviceApplicationTests {

    //	@Test
    //	void contextLoads() {
    //	}

    }
}
