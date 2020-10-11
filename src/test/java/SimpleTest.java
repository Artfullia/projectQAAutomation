import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class SimpleTest {

    protected static WebDriver driver;
    private final Logger log = LogManager.getLogger(SimpleTest.class);
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkTitle(){
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
