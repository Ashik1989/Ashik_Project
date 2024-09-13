package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.*;



public class offlneDeviceCloudStatus
{

    static int countOffline = 0;
    static int countDisconnected = 0;
    static int countBusy = 0;
    static int countUnAuthorised = 0;
    static int countReserved = 1;
    static int countCleaningUp = 0;
    static int countBusyBrowser = 0;

    @Test
    void deviceOfflineStatus(WebDriver driver)
    {
        String deviceName;
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println('\n' + "           TC:004-Status and information of Devices & Browses which are not online is successfully shown     ");
        System.out.println("____________________________________________________________________________________________________________________");

        List<WebElement> deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
        List<WebElement> deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
        //List<WebElement> deviceOffline = deviceInfoIcons.fi
        List<WebElement> deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
        int devicesCount = 1;

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        //System.out.println('\n'+"Total Available Devices:"+deviceStatusBtns.size());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        for (int index = 0; index < deviceStatusBtns.size(); index++) {
            //Extract device name
            deviceName = deviceNames.get(index).getText();

            String deviceStatus = deviceStatusBtns.get(index).getText();
            //System.out.println("No-"+devicesCount+"|Stored Value:" + deviceStatus);
            //List<String> deviceStatusUpdated = Collections.singletonList(deviceStatusBtns.get(index).getText());

            if (deviceName.contains("Pixel") || deviceName.contains("Galaxy") || deviceName.contains("iPad") || deviceName.contains("iPhone"))
            {
                if (deviceStatus.equals("Offline"))
                {
                    devicesCount++;
                    countOffline++;

                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Offline Devices information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.equals("Busy"))
                {
                    devicesCount++;
                    countBusy++;
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();


//                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("element-id")));
//                    element.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    System.out.println("Device:"+deviceName);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Busy Devices information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.equals("Disconnected"))
                {
                    devicesCount++;
                    countDisconnected++;
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Disconnected Devices information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.equals("Unauthorised"))
                {
                    devicesCount++;
                    countUnAuthorised++;
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Unauthorised Devices information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.equals("Reserved"))
                {
                    devicesCount++;
                    countReserved++;

                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Reserved Devices information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.contains("In Use"))
                {
                    devicesCount++;
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Devices which are used for Local execution information:");
                    System.out.println("Device #."+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.equals("Cleaning Up"))
                {
                    devicesCount++;
                    countCleaningUp++;

                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Information of Devices which are Cleaning up:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + stringDeviceUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
            }
            else if (deviceName.contains("Chrome") || deviceName.contains("Firefox") || deviceName.contains("Edge"))
            {
                devicesCount++;
                //System.out.println(deviceStatus);
                if (deviceStatus.equals("Busy"))
                {
                    countBusyBrowser++;

                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(index);
                    elementDeviceInfoButton.click();

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(7) > span:nth-child(2)"));
                    String stringBrowserUDID = elementDeviceUDID.getText();
                    int browserUDID = Integer.parseInt(stringBrowserUDID);

                    System.out.println('\n' + "Busy Browsers information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + browserUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
                else if (deviceStatus.contains("In Use"))
                {
                    devicesCount++;
                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);


                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
                    String stringDeviceUDID = elementDeviceUDID.getText();
                    String stringBrowserUDID = elementDeviceUDID.getText();
                    int browserUDID = Integer.parseInt(stringBrowserUDID);

                    System.out.println('\n' + "Devices which are used for Local execution information:");
                    System.out.println("Device #"+devicesCount+'\n' + "Devices:" + deviceName + '\n' + "Status:" + deviceStatus +'\n'+ deviceIDTxt2 + ":" + intDeviceID + '\n' + "UDID:" + browserUDID);

                    /*Implicit wait*/
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();
                }
            }
             deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
             deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
            //List<WebElement> deviceOffline = deviceInfoIcons.fi
             deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
        }
    }
}
