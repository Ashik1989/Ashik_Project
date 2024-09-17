package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Test
public class accountLogin {

    String  url = "https://public.testgrid.io/signin";
    String name = "TestGrid";
    String url1;
    String url2;
    String url3;
    String url4;
    String url5;
    String url6;
    String url7;
    String url8;
    String url9;
    String url10;

    /*creating driver instance of Chrome class*/
   // WebDriver driver = new ChromeDriver(); commented

//        url1 = "https://poc2.testgrid.io/signin";
//        url2 = "https://poc3.testgrid.io/signin";
//        url3 = "https://poc4.testgrid.io/signin";
//        url4 = "https://poc5.testgrid.io/signin";
//        url5 = "https://poc6.testgrid.io/signin";
//        url6 = "https://poc7.testgrid.io/signin";
//        url7 = "https://poc8.testgrid.io/signin";
//        url8 = "https://poc9.testgrid.io/signin";
//        url9 = "https://poc10.testgrid.io/signin";
//        url10 = "https://poc.testgrid.io/signin";

    /*Authorising the User Credentials and identifying the domain*/

    @Test
    void Validating_Credentials(WebDriver driver) {

        System.out.println("_________________________________________________________________");
        System.out.println('\n'+"             TC:001-Login for the User is successful        ");
        System.out.println("_________________________________________________________________");
        /*Setting the property and specifying the path*/
        //System.set.property(“webdriver.chrome.driver”, ”/Applications”);
        //System.setProperty("webdriver.chrome.driver", "/Applications"); //COMMENTED

        /*maximising the window*/
        //driver.manage().window().maximize();   //COMMENTED

        /*Navigating to the TestGrid URL as per requirement of the domain*/
        driver.get(url);

        /*Implicit wait*/
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


        /*Locating the TestGrid logo*/
        WebElement domain = driver.findElement(By.xpath("//div[@class='form-logo text-center mt-3 mb-5']"));

        boolean logo;

        logo = domain.isDisplayed();

        /*Fetching the Domain name*/
        if(url.contains("testgrid")){
            name = "TestGrid";
        }
        else {
            name = "Some other third party Website";
            System.out.println("validating name: "+name);
        }

        //Initial validation of TestGrid Website
        System.out.println("TestGrid logo is displayed:"+logo);

        //Classification of User account as per URL
        if (url.contains("public") & url.contains("testgrid")) {
            System.out.println("_________________________________");
            System.out.println("User ID belongs to Public account");
            System.out.println("_________________________________");
        } else if (url.contains("poc") & url.contains("testgrid")) {
            System.out.println("______________________________");
            System.out.println("User ID belongs to POC account");
            System.out.println("______________________________");
        } else {
            System.out.println("____________________________________");
            System.out.println("User ID belongs to Dedicated account");
            System.out.println("____________________________________");
        }
    }

    @Test
    /*Fetching User ID and PW to the relevant fields*/
    void Account_login(WebDriver driver) {

        driver.get(url);

      //  driver.manage().window().maximize();  commented

        if (name.contains("TestGrid")) {

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

             //Explicit wait until element is displayed
//           WebDriverWait wait = new WebDriverWait(driver,30);
//           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='¸-input form-control']")));

            /*Locating Username field*/
            WebElement uName = driver.findElement(By.xpath("(//input[@class='inputbox-input form-control'])[1]"));

             /*Fetching the Username*/
            //uName.sendKeys("test2024@gmail.com");

            uName.sendKeys("info@testgrid.io");


            /*Locating Password field*/
            WebElement pwd = driver.findElement(By.xpath("(//input[@class='inputbox-input form-control'])[2]"));

            /*Fetching the Password*/
            //pwd.sendKeys("Test@2024");

            pwd.sendKeys("L2m$noOp");

            /*Implicit wait*/
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //implicitlyWait(10, TimeUnit.SECONDS);


            /*Click on sign in button*/
            WebElement signinBtn = driver.findElement(By.xpath("//button[@class='signin-button']"));
            signinBtn.click();

            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            //Thread.sleep(5);


            //Session overwrite
            //WebElement sessionOverwrite = driver.findElement(By.xpath("//button[@id='btn-confim-overwrite']"));

            //sessionOverwrite.isDisplayed()

            //sessionOverwrite.click();

            /*Explicit wait*/
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            //Logo is displayed after login
            WebElement logo2 = driver.findElement(By.xpath("//div[@class='logo']"));
            logo2.isDisplayed();

        }
        else
        {
            System.out.println("Enter the URL of TestGrid platform");
        }
    }
}


