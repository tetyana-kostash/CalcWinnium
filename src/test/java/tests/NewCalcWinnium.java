package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class NewCalcWinnium {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeClass
    public static void start() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Users\\amigo\\Desktop\\Calculator.exe");
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap);
        wait = new WebDriverWait(driver,30);

    }

    @Test
    public void calculatorTest() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("1")));

        driver.findElement(By.name("1")).click();
        driver.findElement(By.name("2")).click();
        driver.findElement(By.name("3")).click();
        driver.findElement(By.name("+")).click();
        driver.findElement(By.name("4")).click();
        driver.findElement(By.name("=")).click();

        Assert.assertEquals("127",driver.findElement(By.id("1000")).getText());

    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }

}
