package com.bridgelabz;

import com.bridgelabz.util.Utility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bridgelabz.engine.KeywordEngine;

public class LoginTest {
    KeywordEngine keywordEngine;

    @Test
    public void loginTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("login");
    }
    @DataProvider
    public Object[][] getLoginTestData() {
        return Utility.getTestData("login");
    }

    @Test
    public void signupTest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.starExecution("signup");
    }
}
