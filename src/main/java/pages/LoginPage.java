package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import strategies.DriverSingleton;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locator use Page Factory
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement btnLogin;

    @FindBy(xpath = "//h6[contains(@class,'topbar-haeder')]")
    private WebElement txtDashboard;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement btnProfile;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement btnLogout;

// Step Action
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();

    }
    public void logout(){
        btnProfile.click();
        btnLogout.click();
    }

    // Step Validation
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
}
