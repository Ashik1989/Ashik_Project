package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/*Setting up Chrome driver by setting the property like  driver and its path*/

public class testgridTests {

    WebDriver driver = new ChromeDriver();

    @BeforeSuite

    // Set the path to the ChromeDriver executable
    public void setup_Initiation() {

        String  url = "https://public.testgrid.io/signin";
        System.setProperty("webdriver.chrome.driver", "/Applications");

        driver.get(url);

        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        /*Implicit wait*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    // public static void main(String[] args) {

    /*Instantiating driver object, created a instance of login class then
    calling validating_Credentials, Account_login method. Creating instance of device cloudfeature class and
    then  calling method to  validate the individual device feature*/

//    @BeforeClass
//    public void classInstantiation() {
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.manage().window().maximize();
//    }

    @Test
    void callingTest()
    {
        System.out.println("Welcome!!! TestGrid User! Enter Username and Password to Sign in");

        //Created the object of login Module of TestGrid
        accountLogin TG_loginmodule = new accountLogin();

        //TC:1-Calling the method of vaidating the user credentials the TestGrid login page
        TG_loginmodule.Validating_Credentials(driver);
        TG_loginmodule.Account_login(driver);

        /*Implicit wait*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //TC:2-Creating the object and then calling the dedicatedTGFeatures class
//        dedicatedTGFeatures monitorFeature = new dedicatedTGFeatures();
//        monitorFeature.TGFeature(driver);


        //TC:3-Creating the object and then calling the devicecloudStatus class
        devicecloudStatus deviceStatus = new devicecloudStatus();
        deviceStatus.devicesFeature(driver);
        //teardown();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //TC:4-Identifying the devices which are Offline and fetching the information
//        offlneDeviceCloudStatus offlineDevice = new offlneDeviceCloudStatus();
//        offlineDevice.deviceOfflineStatus(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //TC:5-Device connection by clicking the Connect button
//        valdatingConnection connectDevice = new valdatingConnection();
//        connectDevice.Connect_device(driver);

        restartJAR restart = new restartJAR();
        restart.restartUSBPort(driver);

//        //Creating object of Device status
//        devicecloudFeature alldeviceStatus = new devicecloudFeature();
//        alldeviceStatus.devicesFeature();
    }

    @AfterSuite
    public void teardown()
    {
        driver.quit();
    }
}