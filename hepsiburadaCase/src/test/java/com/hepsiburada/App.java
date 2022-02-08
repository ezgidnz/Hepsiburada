package com.hepsiburada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class App {

    static ChromeDriver driver;

    public static void LaunchWebsite(String url) {
         driver = new ChromeDriver();
         driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void switchToNewTab() {

        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(newTb.get(1));

    }

    public static void refreshThePage() {
        driver.navigate().refresh();
    }

    public static void backToPreviousPage() {
        driver.navigate().back();
    }

    public static void setInputByPlaceholder(String placeholder, String productName) {

       driver.findElement(By.xpath(" //*[@placeholder='"+ placeholder + "']")).sendKeys(productName);
    }

    public static void clickByTextToDiv(String text) {
        driver.findElement(By.xpath("//div[contains(text(), '"+text+"')]")).click();
    }

    public static void clickWithContains(String text) {
        driver.findElement(By.xpath("//*[contains(text(), '"+text+"')]")).click();
    }

    public static void clickByid(String text) {
        driver.findElement(By.xpath("//*[@id='"+text+"']")).click();
    }

    public static void clickByClassName(String className,int indexofButton) {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@class='"+className+"']"));
        listOfElements.get(indexofButton).click();
    }


    public static void verifyTextById(String id, String actualtext) {
        //it is verifying the total num of products in the basket
        String expectedtext = driver.findElement(By.xpath("//*[@id='"+id+"']")).getText();
        assertEquals(expectedtext,actualtext);
    }

    public static void verifyByText(String text,int numofElementsIntheBasket) {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]"));

        System.out.println("list of elements "+listOfElements.size());
        for (int i=0;i<listOfElements.size();i++){
            assertTrue(listOfElements.get(i).getText().contains(text));
        }
        assertEquals(numofElementsIntheBasket,listOfElements.size());
    }


    public static void verifyTextByClassNotEqual() {
        List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@class='merchantLink_2Ii8s']"));
        String firstSeller = listOfElements.get(0).getText();
        String secondSeller = listOfElements.get(1).getText();
        assertNotEquals(firstSeller,secondSeller);
    }

    public static void close() {
        driver.quit();

    }


}
