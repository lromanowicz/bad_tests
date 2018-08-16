import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        //Add here your path to chromedriver!!
        System.setProperty("webdriver.chrome.driver", "ENTER_YOUR_PATH_TO_CHROMEDRIVER_HERE");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    /**
     * An example of bad, hard to maintain, and not readable test
     */
    @Test
    public void userShouldBeAbleToRegisterAnAccount() throws InterruptedException {
        WebElement signInButton = driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]"));
        signInButton.click();
        Thread.sleep(3000);

        String randomEmail = "randomowyemail" + ThreadLocalRandom.current().nextInt(1, 100 + 1) + "@testowy.com";
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.sendKeys(randomEmail);

        WebElement createAccountButton = driver.findElement(By.id("SubmitCreate"));
        createAccountButton.click();
        Thread.sleep(3000);

        WebElement titleRadioButtonMr = driver.findElement(By.id("id_gender1"));
        titleRadioButtonMr.click();

        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        firstNameInput.sendKeys("Ziomek");

        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        lastNameInput.sendKeys("Random");

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("SuperPassword123!");

        WebElement daysSelect = driver.findElement(By.id("days"));
        new Select(daysSelect).selectByValue("2");

        WebElement monthsSelect = driver.findElement(By.id("months"));
        new Select(monthsSelect).selectByValue("3");

        WebElement yearsSelect = driver.findElement(By.id("years"));
        new Select(yearsSelect).selectByValue("1993");

        WebElement newsletter = driver.findElement(By.id("uniform-newsletter"));
        newsletter.click();

        WebElement addressFirstname = driver.findElement(By.id("firstname"));
        addressFirstname.sendKeys("Ziomek");

        WebElement addressLastname = driver.findElement(By.id("firstname"));
        addressLastname.sendKeys("Random");

        WebElement addressLine1 = driver.findElement(By.id("address1"));
        addressLine1.sendKeys("SuperAddress1");

        WebElement addressCity = driver.findElement(By.id("city"));
        addressCity.sendKeys("MagnificentCity");

        WebElement stateSelect = driver.findElement(By.id("id_state"));
        new Select(stateSelect).selectByVisibleText("Alaska");

        WebElement addressPostcode = driver.findElement(By.id("postcode"));
        addressPostcode.sendKeys("56555");

        WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("123 345 567");

        WebElement addressAlias = driver.findElement(By.id("alias"));
        addressAlias.sendKeys("SuperAddress");

        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
        Thread.sleep(3000);

        boolean isAccountHeaderDisplayed = driver.findElement(By.cssSelector("#center_column h1")).isDisplayed();
        Assert.assertTrue(isAccountHeaderDisplayed);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
