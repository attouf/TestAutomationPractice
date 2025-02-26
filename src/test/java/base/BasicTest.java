package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import utile.PropertiesReader;

public class BasicTest {

    protected static WebDriver driver;

    public void setUp() throws Exception {
        String browser = PropertiesReader.loadProp("browserName");
        String url = PropertiesReader.loadProp("url");
        if (browser.equals("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start_maximized");
                options.addArguments("--search-engine_choice=country");
                options.addArguments("--disable-notifications");
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                
        }
        else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            //ptions.addArguments("--headless");
            options.addArguments("--private");
            driver = new FirefoxDriver(options);
        }
        driver.get(url);
        System.out.println(driver.getTitle());
    }

    public void tearDown() {
        // driver.quit();

    }

}
