package de.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_004_AdLogin {

    public static void main(String[] arg) throws InterruptedException {


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);   //options.addArguments("--headless");
        driver = new ChromeDriver(options);       //Instantiate Chrome Driver
        driver.manage().window().maximize();

        driver.get(" https://gcreddy.com/project/admin/login.php");

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("gcreddy");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Temp@2020");

        Thread.sleep(3000);
        driver.findElement(By.id("tdb1")).click();

        String urlAdPage = driver.getCurrentUrl();

        System.out.printf(urlAdPage + "\n");

        Boolean compareURL = urlAdPage.equalsIgnoreCase("https://gcreddy.com/project/admin/login.php");

        if (compareURL){
            System.out.printf("there are the same URL");
        }
        else {
            System.out.printf("These URLs are different");
        }




    }
}
