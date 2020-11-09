import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import selenium.WebDriverFactory;

public class SimpleTest {

    protected static WebDriver driver;
    private final Logger log = LogManager.getLogger(SimpleTest.class);
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private String browser = System.getProperty("browser", "cHrOmE2" );

    @Before
    public void setUp(){
        driver = WebDriverFactory.createNewDriver(browser);
    }

    @Test
    public void checkTitleTest(){
        String titleName;
        driver.get(cfg.url());
        log.info("Открыт сайт otus");
        titleName = driver.getTitle();
        Assert.assertEquals(
                "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям",
                titleName);
        log.info("Проверен title сайта");
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
