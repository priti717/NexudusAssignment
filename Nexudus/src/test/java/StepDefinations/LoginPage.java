package StepDefinations;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginPage {

public WebDriver driver;
    @Given("Login page is visible URL {string}")
    public void login_page_is_visible_url(String url) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver\\V114\\chromedriver.exe");
        System.out.println ("Print the login page ------");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);

        driver.get(url);

        driver.manage().window().maximize();
        System.out.println("Successfully login");
    }

    @When("Enter valid Email address {string}")
    public void enter_valid_email_address(String email) {
        driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(email);
        System.out.println("entered email address");
    }
    @When("Enter valid password {string}")
    public void enter_valid_password(String password) {
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(password);
        System.out.println("entered password address");
    }
    @When("Click on Sign in")
    public void click_on_sign_in() {
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Enter sign In");
        String text=driver.findElement(By.xpath("//div[text()='The email or password is incorrect.']")).getText();
       // System.out.println("Print the error"+text);
        Assert.assertEquals("The email or password is incorrect.",text);
    }

    @When("Successful sign in")
    public void Successful_sign_in() {
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println("Enter sign In");

    }
    @Then("close the driver")
    public void close_the_driver() {
         driver.quit();
    }



    @When("navigate to {string}")
    public void navigate_to(String url) {

        driver.get(url);
    }
    @When("Add the Product and fill the details name {string},{string} and {string} fields")
    public void add_the_product_and_fill_the_details_name_and_fields(String Name, String Description, String Price) throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Add product']")).click();
        System.out.println("Product added page");
        driver.findElement(By.xpath("//button[text()='Manual entry']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(Name);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/textarea[1]")).sendKeys(Description);

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).clear();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys(Price);

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("1");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button[class='_button_1cuqw_33 css-t8ynyh-euiButtonDisplay-m-defaultMinWidth-fill-primary'] span[class='css-1bascr2-euiButtonDisplayContent']")).click();
        try {
            driver.findElement(By.cssSelector("button[aria-label='Close this dialog']")).click();
            System.out.println("successfully Product added");
        }catch(Exception e){System.out.println("Exception while closing product page");}
              // driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Name);
      //  driver.findElement(By.className("euiFieldSearch euiFormControlLayout--1icons euiFieldSearch--fullWidth euiFieldSearch-isClearable euiSelectableSearch euiSelectableTemplateSitewide__search")).sendKeys(Name);
        Thread.sleep(3000);
        try {
            driver.findElement(By.cssSelector("input[placeholder='Search...']")).click();
            System.out.println("search click worked");
            driver.findElement(By.cssSelector("input[placeholder='Search...']")).sendKeys(Name);
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Keys.ENTER);
            System.out.println("search send worked");
        }
    catch(Exception e){System.out.println("Exception appeared");
        }

        try{
            driver.findElement(By.xpath("//strong[normalize-space()='test1']")).click();
        }
        catch(Exception e){System.out.println("Exception appeared in search link");
        }
        driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
        try{
            driver.findElement(By.xpath("//span[contains(text(),'Yes, do it')]")).click();
        }catch(Exception e){System.out.println("Exception appeared while deleting product");
        }
    }










}
