import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CheckOut {
    public static void main(String[] args) throws InterruptedException {

        //Set the system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "add directory here/chromedriver.exe");
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

        Thread.sleep(1000);

        //6. Click shopping cart hyperlink
        driver.findElement(By.linkText("Shopping cart")).click();

        //7. Empty shopping cart by iterating over an ArrayList for a checkbox then update shopping cart

        List<WebElement> removefromcart = driver.findElements(By.xpath("//input[@name='removefromcart']"));

        for (int i = 0; i < removefromcart.size(); i++) {
            driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
            driver.findElement(By.xpath("//input[@name='updatecart']")).click();
        }

        driver.navigate().back();

        //8. Mouse over the computers main header using the Actions class
        WebElement mainHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(mainHeader);

        //9. Mouse over the desktop in submenu
        action.moveToElement(driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")));

        //10. compile all the actions into a single step
        action.click().build().perform();

        //11. Click on expensive computer hyperlink
        driver.findElement(By.linkText("Build your own expensive computer")).click();

        //12. Click fast radio button option
        driver.findElement(By.id("product_attribute_74_5_26_82")).click();

        //13. Click 8GB radio button option
        driver.findElement(By.id("product_attribute_74_6_27_85")).click();

        //14. Click 400 GB radio button option
        driver.findElement(By.id("product_attribute_74_3_28_87")).click();

        //15. Click all three check box options
        driver.findElement(By.id("product_attribute_74_8_29_88")).click();
        driver.findElement(By.id("product_attribute_74_8_29_89")).click();
        driver.findElement(By.id("product_attribute_74_8_29_90")).click();

        //16. Add item to shopping cart
        driver.findElement(By.id("add-to-cart-button-74")).click();

        Thread.sleep(1000);

        //17. Click shopping cart hyperlink
        driver.findElement(By.linkText("Shopping cart")).click();

        //18. Click terms of service check box
        driver.findElement(By.id("termsofservice")).click();

        //19. Click checkout button
        driver.findElement(By.id("checkout")).click();

        //20. Use Select class to choose armed forces option for billing address. Note that actions class nor locators worked.
        //I chose to use selectByValue since all three options had values to choose from.
        WebElement billingAddress = driver.findElement(By.xpath("//select[@id='billing-address-select']"));

        Select selectBillingAddress = new Select(billingAddress);

        selectBillingAddress.selectByValue("2694170");

        //21. Click continue button
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        Thread.sleep(1000);

        //22. Use Select class to choose armed forces option for shipping address. Note that actions class nor locators worked.

        WebElement shippingAddress = driver.findElement(By.xpath("//select[@id='shipping-address-select']"));

        Select selectShippingAddress = new Select(shippingAddress);

        selectShippingAddress.selectByValue("2694170");

        //23. Do not choose in-store pickup option and click continue button
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[2]/div[2]/div[1]/input[1]")).click();

        Thread.sleep(1000);

        //24. Ground shipping method is default, click continue button
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]")).click();

        Thread.sleep(1000);

        //25. COD payment method is default, click continue button
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]")).click();

        Thread.sleep(1000);

        //26. Payment information not needed for COD, click continue button
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]")).click();

        Thread.sleep(1000);

        //27. Confirm order by clicking confirm button and take a snapshot of confirmation page
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[2]/input[1]")).click();

        Thread.sleep(1000);

        //TEST---->Take a snapshot and file it in a chosen directory

        //The try catch block below does not require a throws Exception above in the method
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("add directory here"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //        driver.quit();

    }
}
