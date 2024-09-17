package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class valdatingConnection {

    @Test
    void Connect_device(WebDriver driver) {
        System.out.println("________________________________________________________________________________________________________________");
        System.out.println('\n' + "                        TC:005-Broadcasting the Device                                                   ");
        System.out.println("________________________________________________________________________________________________________________");

        int count = 1;


        /*Explicit wait*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Locator for Device type drop down
        WebElement dropdownDeviceType = driver.findElement(By.xpath("//span[text()='Device Type']"));
        //Clicking on it
        dropdownDeviceType.click();
        //Locating Public devices check box
        WebElement publicDeviceCheckbox = driver.findElement(By.xpath("//label[text()='Public']"));
        //Explicit Wait for visibility of Public devices
        wait.until(ExpectedConditions.visibilityOf(publicDeviceCheckbox));
        //Selecting Public devices Checkbox
        publicDeviceCheckbox.click();
        //System.out.println("----------------Check Device Label------------------");
        //Sleep of 5s
        threadWait(5000);
        //Locating all Status buttons assigning it in a list
        List<WebElement> deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
        //Locating all info buttons assigning it in a list
        List<WebElement> deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
        //Locating all Device names assigning it in a list
        List<WebElement> deviceNames = driver.findElements(By.xpath("//div[@class='about-device ml-4']/h6"));
        //Iterating till max size
        for (int i = 0; i < deviceStatusBtns.size(); i++) {
           String deviceStatusBtns_Text = deviceStatusBtns.get(i).getText();

//            System.out.println("1.Status:" + deviceStatusBtns_Temp);
            //Updating the individual name of the device

//            System.out.println("2.Name:" + stringDevicename);
            //Validating the Connect button
            if (deviceStatusBtns_Text.equals("Connect")) {
                String stringDevicename = deviceNames.get(i).getText();
                //System.out.println(deviceStatusBtns);
                //Validating the Device names
                if (stringDevicename.contains("Pixel") || stringDevicename.contains("Galaxy") || stringDevicename.contains("iPad") || stringDevicename.contains("iPhone")) {
                    //Storing the individual Element
                    WebElement connectButton = deviceStatusBtns.get(i);
                    //Explicit wait
                    wait.until(ExpectedConditions.refreshed((ExpectedConditions.elementToBeClickable(connectButton))));
                    //Clicking on Connect
                    connectButton.click();
                    //Explicit wait for windows count
                    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
                    //Switching the window to Real Device cloud window
                    switchToWindow(driver, 2);
                    //Try/catch block
                    try {
                        //Wait till screen is broadcasting
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("screenImg_container")));
                        System.out.println("Device is opened successfully:");
                    } catch (Exception e) {
                        System.out.println("Device is not opened:");
                    }
                    //Switch to 1st window
                    switchToWindow(driver, 1);
                    //Clicking on info button to release the Devices
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
                    //Clicking on it
                    elementDeviceInfoButton.click();
                    //((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementDeviceInfoButton);

                    //Locator for Release device
                    WebElement releaseDevice = driver.findElement(By.xpath("(//a[@class='btn btn-sm real-device-btn text-xs font-weight-500'])[1]"));
                    //Explicit wait Release device element is clickable
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-sm real-device-btn text-xs font-weight-500'])[2]")));
                    //Clicking on Release device
                    releaseDevice.click();
                    //Locating the prompt
                    WebElement releaseDevice_Prompt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
                    //Explicit wait
                    wait.until(ExpectedConditions.visibilityOf(releaseDevice_Prompt));
                    //Acknowledging the prompt
                    releaseDevice_Prompt.click();
                    //Explicit wait to close the Alert is visible
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-outline-light'])[10]")));
                    //Locating Close device info alert
                    //WebElement closeDevicenfo3 = driver.findElement(By.xpath("(//button[@class='btn btn-outline-light'])[10]"));
                    //Clicking on Close device info alert
                    //closeDevicenfo3.click();
                    WebElement closeDevicenfo3 = driver.findElement(By.xpath("(//button[@class='btn btn-outline-light'])[10]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeDevicenfo3);

                    //Thread.sleep
                    threadWait(5000);
                    System.out.println("Device #" + count + ":" + stringDevicename + " & Broadcasting the screen.");
                    //Explicit wait
                    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id]"))));
                    deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
                    deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
                    System.out.println("___________________________________________________________________________________________________");
                } else if (stringDevicename.contains("Chrome") || stringDevicename.contains("Firefox") || stringDevicename.contains("Edge")) {
                    int count_of_Browsers = 1;
                    WebElement connectButton = deviceStatusBtns.get(i);
                    //Explicit wait
                    wait.until(ExpectedConditions.refreshed((ExpectedConditions.elementToBeClickable(connectButton))));
                    //Clicking on Connect
                    connectButton.click();
                    //Explicit wait for windows count
                    wait.until(ExpectedConditions.numberOfWindowsToBe(3));
                    //Switching the window to Real Device cloud window
                    switchToWindow(driver, 2);
                    //Try/catch block
                    try {
                        threadWait(5000);
                        //Wait till screen is broadcasting
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='display software-cursor']")));
                        System.out.println("Browser is opened successfully");
                    } catch (Exception e) {
                        System.out.println("Browser is not opened");
                    }
                    //Switch to 1st window
                    switchToWindow(driver, 1);
                    //Clicking on info button to release the Devices
                    WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
                    //Clicking on it
                    elementDeviceInfoButton.click();

                    //Locator for Release device
                    WebElement releaseDevice = driver.findElement(By.xpath("(//a[@class='btn btn-sm real-device-btn text-xs font-weight-500'])[1]"));
                    //Explicit wait Release device element is clickable
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-sm real-device-btn text-xs font-weight-500'])[2]")));
                    //Clicking on Release device
                    releaseDevice.click();
                    //Locating the prompt
                    WebElement releaseDevice_Prompt = driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled']"));
                    //Explicit wait
                    wait.until(ExpectedConditions.visibilityOf(releaseDevice_Prompt));
                    //Acknowledging the prompt
                    releaseDevice_Prompt.click();
                    //Explicit wait to close the Alert is visible
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-outline-light'])[10]")));
                    //Locating Close device info alert
                    WebElement closeDevicenfo3 = driver.findElement(By.xpath("(//button[@class='btn btn-outline-light'])[10]"));
                    //Clicking on Close device info alert
                    closeDevicenfo3.click();
                    //Thread.sleep
                    threadWait(5000);
                    //Explicit wait
                    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id]"))));
                    deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
                    deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));

                    System.out.println("Browser #" + count_of_Browsers + ":" + stringDevicename + " & Broadcasting the screen.");
                    System.out.println("___________________________________________________________________________________________________");
                    //driver.navigate().refresh();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    driver.navigate().to("https://public.testgrid.io/devicecloud#");
                    count_of_Browsers++;
                } else {
                    System.out.println("Device Not available");
                }


                //driver.switchTo().window("Devices | Device Cloud");
                count++;

            }
            //Locator for Release device
            WebElement releaseDevice = driver.findElement(By.xpath("(//a[@class='btn btn-sm real-device-btn text-xs font-weight-500'])[1]"));
            deviceStatusBtns = driver.findElements(By.xpath("//button[@id]"));
            deviceInfoIcons = driver.findElements(By.xpath("//*[@class='device-info']"));
            WebElement elementDeviceInfoButton = deviceInfoIcons.get(i);
        }
    }

    public void switchToWindow(WebDriver driver, int index) {
        Set<String> windows = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windows);
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


