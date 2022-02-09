package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class LanguageTest {

    private Language language= new Language();


    @Test
    public void constructortest(){
        assertTrue("Its not an instance of Language",language instanceof Language);
    }




}
