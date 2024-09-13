package org.example;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import static java.lang.Thread.sleep;

public class devicecloudStatus {

    @Test
    void devicesFeature(WebDriver driver) {
        String dev_Status;
        System.out.println('\n' + "----------TC:003-Status and information of Devices & Browses which are online is successfully shown-----------");


        //  WebDriver driver = new ChromeDriver();

        /*Locating Device cloud Element*/
        WebElement devicecloudFeature = driver.findElement(By.xpath("//span[text() = 'Real Device Cloud']"));

        //Opening device cloud
        devicecloudFeature.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        String parent = driver.getWindowHandle();
        Set<String> str = driver.getWindowHandles();

        // Now iterate using Iterator
        for (String child_window : str) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                //.switchTo().window(child_window).getTitle()
                System.out.println("Current window is:" + driver.getTitle());
                System.out.println("Parent window is:" + driver.getWindowHandle());
            }
        }


        //check for dynamic webelements

        //div[@class='d-flex align-items-center mb-1']
        int count = 1;
        int countOffline = 0;
        WebElement deviceInfo;
        WebElement elementDeviceStatus;


//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,5000)");

        List<WebElement> deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
        List<WebElement> deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
        List<WebElement> deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));

        System.out.println('\n' + "Total Available Devices:" + deviceStatusBtns.size());

        for (int i = 0; i < deviceStatusBtns.size(); i++) {
            String deviceStatus = deviceStatusBtns.get(i).getText();

            if (deviceStatus.equals("Connect")) {
                String deviceName = deviceNames.get(i).getText();
                if (deviceName.contains("Pixel") || deviceName.contains("Galaxy") || deviceName.contains("iPad") || deviceName.contains("iPhone")) {
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringdeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringdeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();


                    System.out.println('\n' + "Online Devices information:");
                    System.out.println("Device Count : " + count + '\n' + "DeviceName : " + deviceName + '\n' + "Device is ready to:" + deviceStatus + '\n' + "Device ID:" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);


                    //System.out.println("Device is:" + deviceName + '\n' + "Status of the device is ready to:" + deviceStatus + '\n' + "Device ID:" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    closeDeviceInfo.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                } else if (deviceName.contains("Chrome") || deviceName.contains("Firefox") || deviceName.contains("Edge")) {
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringdeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringdeviceID);

                    WebElement elementBrowserUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(7) > span:nth-child(2)"));
                    String stringBrowserUDID = elementBrowserUDID.getText();
                    int browserUDID = Integer.parseInt(stringBrowserUDID);

                    System.out.println('\n' + "Online Devices information:");
                    System.out.println("Device Count : " + count + '\n' + "Device Name: " + deviceName + '\n' + "Device is ready to: " + deviceStatus + '\n' + "Device ID:" + intDeviceID + '\n' + "UDID:" + browserUDID);

                    //System.out.println("Device is:" + deviceName + '\n' + "Status of the device is ready to:" + deviceStatus + '\n' + "Device ID:" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    closeDeviceInfo.click();
                } else {
                    System.out.println("Device/browser doesn't exist-1");
                }
            }
            deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
            deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
            deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
            count++;
        }
    }
}








