package com.hepsiburada.apiTesting;

import static org.junit.Assert.*;

public class apiAutomation {


    public static void verifyTextByEqual(String expected, String actual ) {
        assertEquals(expected,actual);
    }
    public static void verifyTextByNotEqual(String expected, String actual ) {
        assertNotEquals(expected,actual);
    }

    public static void verifyTextIsEmpty(String text) {
        assertTrue(text.equals("[]"));
    }


}
