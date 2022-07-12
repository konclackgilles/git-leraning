package de.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_003_Login_Check {

    public static void main(String[] arg) throws InterruptedException {


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);   //options.addArguments("--headless");
        driver = new ChromeDriver(options);       //Instantiate Chrome Driver
        driver.manage().window().maximize();

        driver.get(" https://gcreddy.com/project/login.php");

       /* driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("SidduRiBwBHsn@gmail.com");
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcd321");
        driver.findElement(By.id("tdb1")).click();

        */

        driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("meghala1234S@gmail.com");
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("xyz4321");
        driver.findElement(By.id("tdb1")).click();

        String codeSource = driver.getPageSource();

        if (codeSource.contains("Log Off")){
            System.out.printf("Log Off: exist");
        }



    }
}
