package de.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestClass {

    public static void main(String[] arg) throws InterruptedException {


        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);   //options.addArguments("--headless");
        driver = new ChromeDriver(options);       //Instantiate Chrome Driver
        driver.manage().window().maximize();

        driver.get("https://gcreddy.com/project/create_account.php");

        driver.findElement(By.name("gender")).click(); // Radio Button
        driver.findElement(By.name("firstname")).sendKeys("abcd"); // text box
        driver.findElement(By.name("lastname")).sendKeys("xyz");// text box
        driver.findElement(By.id("dob")).sendKeys("10/10/2000");

        //String email = "sriniram123″+ Math.random()+ "@gmail.com";
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        String email = "Siddu"+generatedstring+"@gmail.com"; //Random mail generate
        System.out.println(email);
        driver.findElement(By.name("email_address")).sendKeys(email);

        driver.findElement(By.name("street_address")).sendKeys("abcd 2 xyz");
        driver.findElement(By.name("postcode")).sendKeys("500072");
        driver.findElement(By.name("city")).sendKeys("Hyderabad");
        driver.findElement(By.name("state")).sendKeys("Telangana");

        Select dropDown = new Select (driver.findElement(By.name("country"))); // DropDown
        dropDown.selectByVisibleText("India");

        driver.findElement(By.name("telephone")).sendKeys("9876767676");
        driver.findElement(By.name("password")).sendKeys("abcd321");
        driver.findElement(By.name("confirmation")).sendKeys("abcd321");

        driver.findElement(By.id("tdb4")).click(); // Button
        driver.findElement(By.name("password")).sendKeys("abcd321");
        driver.findElement(By.name("confirmation")).sendKeys("abcd321");
        Thread.sleep(5000);

        driver.findElement(By.id("tdb4")).click();
        Thread.sleep(3000);

        String confirmationMessage = driver.findElement(By.tagName("h1")).getText();

        if (confirmationMessage.equals("Your Account Has Been Created!"))
        {
            System.out.println("Passed - Account created");
        }
        else
        {
            System.out.println("Failed - Account could not be created");
        }
        //driver.close();

        String conMge = driver.getPageSource();



        if (conMge.contains("Your Account Has Been Created!")){
            System.out.printf("yes it exist" + "\n");
            //System.out.printf(title + "\t" + "is the title");
        }

    }
}
