package mail;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class MailTest {
     WebDriver driver;
    private static DesiredCapabilities desiredCapabilities;

    @BeforeClass
    public void setUpClass() throws MalformedURLException {
        desiredCapabilities = new DesiredCapabilities().chrome();
        desiredCapabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL("http://10.6.218.14:4444/wd/hub"), desiredCapabilities);
       //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       //driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void singInTest(){
        SingInPage singInPage = new SingInPage(driver).getBasePage().getUserAccount().isUserSignIn();
       // DraftsPage draftsPage = new DraftsPage(driver).getDrafts().checkEmailInDrafts().sendEmailFromDrafts();
       //
       // emailWritePage.getEmailSendData();
    }

    @Test(priority = 2)
    public void emailWriteTest(){
        EmailWritePage emailWritePage = new EmailWritePage(driver).writeEmail().saveEmailAsDraft();
    }

    @Test(priority = 3)
    public void draftTest(){
        DraftsPage draftsPage = new DraftsPage(driver).getDrafts().checkEmailInDrafts().sendEmailFromDrafts();
    }

    @Test(priority = 4)
    public void getDataEmailTest(){
        EmailWritePage emailWritePage = new EmailWritePage(driver).getEmailSendData();
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
