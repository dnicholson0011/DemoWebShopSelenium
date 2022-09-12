import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {

        //Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Selenium WebDrivers\\Chrome Drivers/chromedriver.exe");
        //Create driver object for Chrome browser
        WebDriver driver = new ChromeDriver();

        //1. Goto URL
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        //2. Click on log in hyperlink
        driver.findElement(By.className("ico-login")).click();

        //3. Enter registered email into text box field
        driver.findElement(By.id("Email")).sendKeys("first.last@example01.test");

        //4. Enter registered password into text box field
        driver.findElement(By.id("Password")).sendKeys("123456");

        //5. Click log in button
        driver.findElement(By.className("login-button")).click();

        driver.quit();

    }
}
