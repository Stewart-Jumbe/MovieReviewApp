package com.tsi.sjumbe.demoTest;


import com.tsi.sjumbe.demo.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {


    private Category category = new Category();

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

}
