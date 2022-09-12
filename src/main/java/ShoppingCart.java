import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCart {
    public static void main(String[] args) throws InterruptedException {

        //Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\d.nicholson\\OneDrive - Accenture\\Desktop\\Test Scripts\\Selenium WebDrivers\\Chrome Drivers/chromedriver.exe");
        //Create driver object for Chrome browser
        WebDriver driver = new ChromeDriver();

        //1. Goto URL
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        //2. Mouse over the computers main header
        WebElement mainHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(mainHeader);

        //3. Mouse over the desktop in submenu
        action.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")));

        //4. compile all the actions into a single step
        action.click().build().perform();

        //5. Click on expensive computer hyperlink
        driver.findElement(By.linkText("Build your own expensive computer")).click();

        //6. Click fast radio button option
        driver.findElement(By.id("product_attribute_74_5_26_82")).click();

        //7. Click 8GB radio button option
        driver.findElement(By.id("product_attribute_74_6_27_85")).click();

        //8. Click 400 GB radio button option
        driver.findElement(By.id("product_attribute_74_3_28_87")).click();

        //9. Click all three check box options
        driver.findElement(By.id("product_attribute_74_8_29_88")).click();
        driver.findElement(By.id("product_attribute_74_8_29_89")).click();
        driver.findElement(By.id("product_attribute_74_8_29_90")).click();

        //10. Add item to shopping cart
        driver.findElement(By.id("add-to-cart-button-74")).click();

        Thread.sleep(1000);

        //11. Click
        driver.findElement(By.linkText("Shopping cart")).click();

//        driver.quit();

    }
}
