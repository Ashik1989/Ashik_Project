package org.example;

import org.junit.platform.commons.function.Try;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.annotation.Native;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.E;

//import static com.sun.tools.javac.resources.CompilerProperties.Fragments.Static;

@Test
public class dedicatedTGFeatures {

    /*creating driver instance of Chrome class*/
    // WebDriver driver = new ChromeDriver(); commented
    static int count = 1;
    /*Setting the property and specifying the path*/
    //System.set.property(“webdriver.chrome.driver”, ”/Applications” );

    WebElement seleniumFeatureDisable;

    WebElement appiumFeatureEnable;

    WebElement codelessFeatureEnable;

    WebElement nativeTestEnable;

    WebElement nativeTestDisable;

    WebElement seleniumFeatureEnable;

    WebElement appiumFeatureDisable;

    WebElement virtualUSBFeatureEnable;

    WebElement integrationFeatureEnable;

    WebElement integrationFeatureDisable;


    void TGFeature(WebDriver driver)
    {

        System.out.println("__________________________________________________________________________");
        System.out.println('\n'+"          TC:002-Features monitoring for the User is successful      ");
        System.out.println("__________________________________________________________________________");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //String publicURL = "https://public.testgrid.io/signin";

        String URL;
        //= "https://public.testgrid.io/signin";

        //Fetching the URL
        URL = driver.getCurrentUrl();

        System.out.println(URL);

        //driver.get(URL);

        //Implicit wait of 10seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement user = driver.findElement(By.xpath(("//*[@id='profile_drop_down']/a/span")));
        ;
        //If user account is of public domain
        boolean status = URL.contains("public");
        String userName;

        //Extracting  text of the Current user
        userName = user.getText();
        //8int codelessCount = 0;

        //if status is true
        if (status)
        {

            WebElement Automation_section = driver.findElement(By.xpath(("//button[text()='Automation']")));

            if (Automation_section.isDisplayed())
            {

                try {
                         //Element for the feature Codeless feature Disable
                        WebElement codelessFeatureEnable = driver.findElement(By.xpath("(//span[text()='Codeless'])[1]"));
                        String codelessFeature = codelessFeatureEnable.getText();
                        if(codelessFeatureEnable.isEnabled() && codelessFeature.contains("Codeless") && codelessFeatureEnable.isDisplayed())
                        {
                            System.out.println("1-Codeless feature is Enabled for the user:"+userName);
                        }
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Codeless feature|" + e);
                }

                //try {
                //Element for the feature Selenium feature Disable
                // seleniumFeatureDisable = driver.findElement(By.xpath("//li[@id='selenium_disabled_li']"));
                //} catch (org.openqa.selenium.NoSuchElementException e) {
                // System.out.println("WARNING-1!!!Specific locator is not available for Selenium Testing Disable" + e);
                //}

                try {
                    //Element for the feature Native Test Enable
                    nativeTestEnable = driver.findElement(By.xpath("//span[text()='Native Test']"));
                    String nativeTestFeatue = nativeTestEnable.getText();
                    if((nativeTestEnable.isEnabled() && nativeTestEnable.isDisplayed() && nativeTestFeatue.contains("Native Test")))
                    {
                        System.out.println("2-Native Test feature is Enabled for the user:"+userName);
                    }
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Native Testing En|" + e);
                }

                try {
                    //Element for the feature VirtualUSB
                    virtualUSBFeatureEnable = driver.findElement(By.xpath("//span[text()='Virtual USB']"));
                    String virtualUSBFeature = virtualUSBFeatureEnable.getText();
                    if(virtualUSBFeatureEnable.isEnabled() && virtualUSBFeatureEnable.isDisplayed() && virtualUSBFeature.contains("Virtual USB"))                    {
                        System.out.println("3-Virtual USB feature is Enabled for the user:"+userName);
                    }
                } catch (org.openqa.selenium.NoSuchElementException e){
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Virtual USB Enable|" + e);
                }



                try {
                    //Element for the feature Integration feature disable
                    integrationFeatureEnable = driver.findElement(By.xpath("//*[@id='menu_main']/li[7]/a/span"));
                } catch (org.openqa.selenium.NoSuchElementException e){
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Integration feature Disabled|" );
                }

                try{
                    //Element for the feature Integration feature disable
                    integrationFeatureDisable = driver.findElement(By.xpath("//a[@class='custom-upgrade_plan disabled']"));
                }
                catch(org.openqa.selenium.NoSuchElementException e)
                {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Integration feature Enabled|");
                }

//                        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                        Alert alert = driver.switchTo().alert();
//                        WebElement upgrdePlan = driver.findElement(By.xpath("//*[@id='lock_upgrade_btn_modal']/div[2]/div/div[1]/h4"));
//                        if (upgrdePlan.isDisplayed())
//                        {
//                            WebElement upgradePlanText = driver.findElement(By.xpath("//*[@id='lock_upgrade_btn_modal']/div[2]/div/div[1]/h4"));
//                            String planText = upgradePlanText.getText();
//                            System.out.println(planText);
//                            WebElement cancelBtn = driver.findElement(By.xpath("(//button[text()='Cancel'])[14]"));
//                            cancelBtn.click();
//                            System.out.println("4-Integrations feature is Disabled for the user:" + userName);
//                        }
  //                  }
//                } catch (org.openqa.selenium.NoSuchElementException e){
//                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Integrations feature|" + e);
//                }

                try {
                    //Element for the feature Native Test Disable
                    nativeTestDisable = driver.findElement(By.xpath("(//a[@id='native_test'])[1]"));
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Native Testing Dis" + e);
                }

                //Element for the feature Performance Test Enable
                //WebElement performanceTestEnable = driver.findElement(By.xpath("//*[@id='tgdashboard_jmeter']/span"));

                try {
                    //Element for the feature Selenium feature Enable
                    seleniumFeatureEnable = driver.findElement(By.xpath("//*[@id='selenium_li']/a/span"));
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Selenium Testing Enable|" + e);
                }

                try {
                    //Element for the feature Appium feature Enable
                    appiumFeatureEnable = driver.findElement(By.xpath("//*[@id='appium_li']/a/span"));
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Appium Testing Enable|" + e);
                }

                try {
                    //Element for the feature Appium feature Disable
                    appiumFeatureDisable = driver.findElement(By.xpath("//li[@id='appium_disabled_li']"));
                } catch (org.openqa.selenium.NoSuchElementException e){
                    System.out.println('\n'+"WARNING-1!!!Specific locator is not available for Appium Testing Disable|" + e);
                }



                //WebElement virtualUSBDisable = driver.findElement(By.xpath(""));






//                //Currently active features for the user as per the Dashboard
//                try{
//                    if (codelessFeatureEnable.isDisplayed() || codelessFeatureEnable.isDisplayed())
//                    {
//                        //codelessCount++;
//                        System.out.println('\n' + count + "-Codeless feature is Enabled for the user: " + userName);
//                    }
//                }catch (NoSuchElementException e){
//                    //E.printStackTrace();
//                    System.out.println('\n'+"WARNING-2!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//
//
//                try {
//
//                    //seleniumFeatureEnable.isEnabled() ||
//                    if (seleniumFeatureEnable.isDisplayed() || !(seleniumFeatureDisable.isDisplayed()))
//                    {
//                        count++;
//                        System.out.println('\n' + count + "-Selenium feature is Enabled for the user:" + userName);
//                    }
//                }
//                catch (NoSuchElementException e){
//                    //E.printStackTrace();
//                    System.out.println('\n'+"WARNING-2!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//
//                try{
//
//                    if (appiumFeatureEnable.isEnabled() || appiumFeatureEnable.isDisplayed() || !(appiumFeatureDisable.isDisplayed()))
//                    {
//                        count++;
//                        System.out.println('\n' + count + "-Appium feature is Enabled for the user:" + userName);
//                    }
//                }catch (NoSuchElementException e) {
//                    //E.printStackTrace();
//                    System.out.println('\n' + "WARNING-2!!!Cannot able to locate the feature availability of specific Elements|" + e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//
//                try {
//                    if (nativeTestEnable.isEnabled() || nativeTestEnable.isDisplayed() || !(nativeTestDisable.isDisplayed()))
//                    {
//                        count++;
//                        System.out.println('\n' + count + "-Native Test feature is Enabled for the user:" + userName);
//                    }
//                }
//                catch (NoSuchElementException e){
//                    //E.printStackTrace();
//                    System.out.println('\n'+"WARNING-2!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//
//                try {
//                    if (virtualUSBFeatureEnable.isEnabled() || virtualUSBFeatureEnable.isDisplayed())
//                    {
//                        count++;
//                        System.out.println('\n' + count + "-Virtual USB, feature is Enabled for the user:" + userName);
//                    }
//                }
//                catch (NoSuchElementException e){
//                    //E.printStackTrace();
//                    System.out.println('\n'+"WARNING-2!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//
//                try {
//                    if (integrationFeatureEnable.isEnabled() || integrationFeatureEnable.isDisplayed())
//                    {
//                        count++;
//                        System.out.println('\n' + count + "-IntegrationFeature, is Enabled for the user:" + userName);
//                    }
//                    else
//                    {
//                        System.out.println('\n' + "All features are disabled for user");
//                    }
//                }catch (NoSuchElementException e){
//                    //E.printStackTrace();
//                    System.out.println('\n'+"WARNING-2!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }
//                catch (NullPointerException e)
//                {
//                    System.out.println('\n'+"WARNING-3!!!Cannot able to locate the feature availability of specific Elements|"+e);
//                }

            }
            //Feature availability for the User
//                if (count == 0)
//                {
//                    System.out.println("Codeless feature is only active for the User"+ userName);
//                }
//                else if(count != 3)
//                {
//                    System.out.println("Except Codeless rest all feature is disabled for the User: "+ userName);
//                }
//                else{
//                    System.out.println("Few features are disabled for the User: "+userName);
//                }
        }
        else
        {
            System.out.println('\n'+"Use only public account to Test");
        }

    }

}
