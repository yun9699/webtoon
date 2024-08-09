package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KBSRadio {

    public static void main(String[] args)throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("https://program.kbs.co.kr/1fm/radio/musicall/pc/index.html");

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.cssSelector(".header-menu-pg li:first-child"));

        element.click();

        Thread.sleep(1000);

        WebElement playListUL = element.findElement(By.cssSelector(".menu-sub"));

        System.out.println(playListUL.getText());

        Thread.sleep(1000);

        playListUL.findElement(By.cssSelector("a")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}