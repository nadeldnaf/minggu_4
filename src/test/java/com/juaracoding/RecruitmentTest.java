package com.juaracoding;
import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.RecruitmentPage;

public class RecruitmentTest {
        private WebDriver driver;

        private RecruitmentPage recruitmentPage;

        @BeforeClass
        public void setUp(){
                recruitmentPage = new RecruitmentPage();
                recruitmentPage.performAddCandidate();
        }
        @Test(priority = 1)
        public void testInputFirstName(){
                recruitmentPage.fillFirstName("Setiawan");
                Assert.assertEquals(recruitmentPage.getFirstNameValue(), "Setiawan");
        }

        @Test(priority = 2)
        public void testInputMiddleName(){
                recruitmentPage.fillMiddleName("Anggi");
                Assert.assertEquals(recruitmentPage.getMiddleNameValue(), "Anggi");
        }
        @Test(priority = 3)
        public void testInputLastName(){
                recruitmentPage.fillLastName("Elanda");
                Assert.assertEquals(recruitmentPage.getLastNameValue(), "Elanda");
        }
        @Test(priority = 4)
        public void testInputVacancy(){
                recruitmentPage.vacancySelect.click();
                delay(2);
                int arrowDownCount = 7;
                for (int i = 0; i < arrowDownCount; i++) {
                        recruitmentPage.vacancySelect.sendKeys(Keys.ARROW_DOWN);
                }
                recruitmentPage.vacancySelect.sendKeys(Keys.ENTER);
                Assert.assertEquals(recruitmentPage.getVacancySelectValue(), "Design Grafis");
        }
        @Test(priority = 5)
        public void testInputEmail(){
                recruitmentPage.fillEmailField("elandaanisa@gmail.com");
                Assert.assertEquals(recruitmentPage.getEmailValue(), "elandaanisa@gmail.com");
        }
        @Test(priority = 6)
        public void testInputContactNumber(){
                recruitmentPage.fillContactNumber("089626117516");
                Assert.assertEquals(recruitmentPage.getContactNumberValue(), "089626117516");
        }
        @Test(priority = 7)
        public void testInputResume(){
                recruitmentPage.chooseResume("C:\\MyTools\\example.txt");
                Assert.assertEquals(recruitmentPage.getResumeUploadValue(), "C:\\fakepath\\example.txt");
        }
        @Test(priority = 8)
        public void testInputKeyword(){
                recruitmentPage.fillKeyword("Quality Control");
                Assert.assertEquals(recruitmentPage.getKeywordValue(), "Quality Control");
        }
        @Test(priority = 9)
        public void testDateOfApplication(){
                recruitmentPage.chooseDateOfApplicant("2000-09-02");
                Assert.assertEquals(recruitmentPage.getDateOfApplicationValue(), "2000-09-02");
        }
        @Test(priority = 10)
        public void testInputNotes(){
                recruitmentPage.fillNotes("Juara Coding");
                Assert.assertEquals(recruitmentPage.getNotesValue(), "Juara Coding");
        }
}



