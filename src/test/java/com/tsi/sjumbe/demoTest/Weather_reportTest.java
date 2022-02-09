package com.tsi.sjumbe.demoTest;

import com.tsi.sjumbe.demo.Weather_report;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class Weather_reportTest {
    Weather_report wreport = new Weather_report();

    @Test
    public void testSunnyWeather(){
        boolean wreportResult = wreport.sunnyToday(true);
        assertEquals(true,wreportResult,"its not working");
    }
}
