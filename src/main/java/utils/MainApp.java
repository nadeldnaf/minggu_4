package utils;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import strategies.DriverSingleton;

public class MainApp {

    private static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
                driver.get(url);


        // Call method from pages
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin","admin123");
        System.out.println(loginPage.getTxtDashboard());

        //tambahan invalid login
        loginPage.logout();
        loginPage.login("Adminn","admin1234");


        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}
