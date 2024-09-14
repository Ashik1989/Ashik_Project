package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.*;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.*;
import org.openqa.selenium.WebDriver;

public class restartJAR {

    void offlineDeviceStatus(WebDriver driver) {

        String deviceName;
        System.out.println("____________________________________________________________________________________________________________________");
        System.out.println('\n' + "           TC:006-Restarting the USB Port of Devices & Browses which are not online     ");
        System.out.println("____________________________________________________________________________________________________________________");

        List<WebElement> deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
        List<WebElement> deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
        //List<WebElement> deviceOffline = deviceInfoIcons.fi
        List<WebElement> deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
        int devicesCount = 1;

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //System.out.println('\n'+"Total Available Devices:"+deviceStatusBtns.size());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (int i = 0; i < deviceStatusBtns.size(); i++) {
            //Extract device name
            deviceName = deviceNames.get(i).getText();

            String deviceStatus = deviceStatusBtns.get(i).getText();
            //System.out.println("No-"+devicesCount+"|Stored Value:" + deviceStatus);
            //List<String> deviceStatusUpdated = Collections.singletonList(deviceStatusBtns.get(index).getText());

            if(deviceName.contains("Pixel") || deviceName.contains("Galaxy") || deviceName.contains("iPad") || deviceName.contains("iPhone") || deviceName.contains("Chrome") || deviceName.contains("Firefox") || deviceName.contains("Edge"))
            {
                if (deviceStatus.equals("Offline") || (deviceStatus.equals("Busy") || (deviceStatus.equals("Disconnected") || (deviceStatus.equals("Unauthorised"))))) {
                    devicesCount++;

                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
                    elementDeviceInfoButton.click();

                    /*Explicit wait*/
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

                    /*Implicit wait*/
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
                    switchToWindow(driver, 1);

                    WebElement deviceIDTxt = driver.findElement(By.xpath("(//*[@class='fw-500'])[1]"));
                    String deviceIDTxt2 = deviceIDTxt.getText();
                    WebElement elementDeviceID = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[1]/div/div[1]/ul/li[1]/span[2]"));
                    String stringDeviceID = elementDeviceID.getText();
                    int intDeviceID = Integer.parseInt(stringDeviceID);

//                    WebElement elementDeviceUDID = driver.findElement(By.cssSelector("#cap_builder_modal > div > div > div.modal-body.p-0 > div > div:nth-child(1) > ul > li:nth-child(10) > span:nth-child(2)"));
//                    String stringDeviceUDID = elementDeviceUDID.getText();

                    System.out.println('\n' + "Offline Devices information:");
                    System.out.println("Device #" + devicesCount + '\n' + "Device:" + deviceName + '\n' + "Status:" + deviceStatus + '\n' + deviceIDTxt2 + ":" + intDeviceID + '\n');

                    /*Implicit wait*/
                    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement restartUSBPort = driver.findElement(By.xpath("//a[@class='btn btn-sm real-device-btn text-xs font-weight-500']"));
                    wait.until(ExpectedConditions.elementToBeClickable(restartUSBPort));


                    //Calling Restart USB Port method
                    //for(count = 0; count <= 3;count++)
                    //{
                        if(restartUSBPort.isEnabled() && restartUSBPort.isDisplayed())
                        {
                            wait.until(ExpectedConditions.elementToBeClickable(restartUSBPort));
                            switchToWindow(driver,1);
                            restartUSBPort.click();
                            threadWait(5000);
                            switchToWindow(driver,1);
                            //driver.switchTo().alert();
                            //threadWait(5000);
                            WebElement restartUSBPortPrompt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
                            restartUSBPortPrompt.click();
                            System.out.println("Restarted the USB Port of:"+deviceName+"|Device Status:"+deviceStatus+"+");
                        }
                    threadWait(5000);
                    //switchToWindow(driver,2);
                    WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                    closeDeviceInfo.click();

                    deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
                    deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
                    //List<WebElement> deviceOffline = deviceInfoIcons.fi
                    deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
                }
            }
        }
                /*Implicit wait*/
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement closeDeviceInfo = driver.findElement(By.xpath("//*[@id='cap_builder_modal']/div/div/div[2]/div/button"));
                closeDeviceInfo.click();
    }


    public void switchToWindow(WebDriver driver, int index) {
        Set<String> windows = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windows);
        //System.out.println(list.size());
        driver.switchTo().window(list.get(index));
    }

    public void threadWait(long timeOutInSeconds) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

