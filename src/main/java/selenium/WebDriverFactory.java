package selenium;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public interface WebDriverFactory {

    static WebDriver createNewDriver (String webDriverName, Object ... option) {
        Object driverOptions = null;
        if(option.length == 1){
            driverOptions = option[0];
        }
        switch (BrowserType.getBrowserTypeByName(webDriverName)){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return (driverOptions instanceof ChromeOptions) ?
                        new ChromeDriver((ChromeOptions) driverOptions) :
                        new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return (driverOptions instanceof FirefoxOptions) ?
                        new FirefoxDriver((FirefoxOptions) driverOptions) :
                        new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Could not create web driver");
        }
    }
}
