package com.mf.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringTransformationTest {

    @Test(dataProvider = "happyCase")
    public void testStringTransformationHappyCase(String firstString, String secondString, int noOfOperations, String canConvert){
        String isConvertable = StringTransformation.appendAndDelete(firstString, secondString, noOfOperations);
        Assert.assertEquals(isConvertable.toLowerCase(), canConvert.toLowerCase());
    }

    @Test(dataProvider = "unhappyCase", expectedExceptions = IllegalArgumentException.class)
    public void testStringTransformationUnHappyCase(String firstString, String secondString, int noOfOperations){
       StringTransformation.appendAndDelete(firstString, secondString, noOfOperations);
    }

    @DataProvider(name = "happyCase")
    public Object[][] happyCaseInput(){
        return new Object[][] {
                {"abc", "def", 6, "Yes"},
                {"hackerhappy", "hackerrank", 9, "Yes"},
                {"aba", "aba", 7, "Yes"},
                {"ashley", "ash", 2, "No"},
                {"", "", 0, "Yes"}
        };
    }

    @DataProvider(name = "unhappyCase")
    public Object[][] unhappyCaseInput(){
        return new Object[][] {
                {"abc", "def", -2}
        };
    }
}
