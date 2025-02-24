package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class BasicTest {

    protected static WebDriver driver;

 
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start_maximized");
        options.addArguments("--search-engine_choice=country");
        options.addArguments("--disable-notifications");
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://www.automationpractice.pl/index.php");
        System.out.println(driver.getTitle());
    }

  
    public void tearDown() {
     // driver.quit();
      
    }

}
