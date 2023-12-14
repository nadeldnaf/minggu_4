package com.juaracoding;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import strategies.DriverSingleton;

public class LoginTest {
    private WebDriver driver;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.login("Admin","admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(),"Dashboard");
    }
    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.logout();
        loginPage.login("Adminn","admin1234");
        Assert.assertTrue(loginPage.getTxtInvalidLogin().contains("Invalid"));
    }

    @Test(priority = 3)
    public void testUsernameNull(){
        loginPage.login("","admin1234");
        Assert.assertEquals(loginPage.getTxtRequired(),"Required");
    }
}
