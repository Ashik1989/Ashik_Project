//package org.example;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class Main {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        /*Implicit wait*/
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        //driver.manage().timeouts().implicitlywait(10, TimeUnit.SECONDS);
//
//        System.out.println("Hello TestGrid User! Enter Username and Passsword to Sign in");
//
//        //Created the object of login Module of Testgrid module
//        TestGridTests TG_loginmodule = new TestGridTests();
//
//        /*Calling the methods*/
//        TG_loginmodule.validating_Credentials();
//        TG_loginmodule.Account_login();
//
//        /*Implicit wait*/
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        //Creating object of Device status
//        devicecloudFeature alldeviceStatus = new devicecloudFeature();
//        alldeviceStatus.devicesFeature();
//    }
//}