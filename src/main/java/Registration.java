import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    public static void main(String[] args) {

        //Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Selenium WebDrivers\\Chrome Drivers/chromedriver.exe");
        //Create driver object for Chrome browser
        WebDriver driver = new ChromeDriver();

        //1. Goto URL
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        //2. Click on register hyperlink
        driver.findElement(By.className("ico-register")).click();

        //3. Click male radio button
        driver.findElement(By.id("gender-male")).click();

        //4. Enter valid first name into text box field
        driver.findElement(By.id("FirstName")).sendKeys("First");

        //5. Enter valid last name into text box field
        driver.findElement(By.id("LastName")).sendKeys("Last");

        //6. Enter a valid email into text box field
        driver.findElement(By.id("Email")).sendKeys("first.last@example001.test");

        //7. Enter a valid password into text box field
        driver.findElement(By.id("Password")).sendKeys("123456");

        //8. Enter a valid password into text box field
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        //9. Click register button
//        driver.findElement(By.id("register-button")).click();

//        driver.quit();

    }
}
