// Generated by Selenium IDE
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ClickMeBabyOneMoreTimeTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private final String BASE_URL = "https://furbo.sk/playground/clickmebaby.php";
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void clickOnce() {
    driver.get(BASE_URL);
    driver.findElement(By.id("clickMe")).click();
    assertThat(driver.findElement(By.id("clicks")).getText(), is("1"));
    assertThat(driver.findElement(By.cssSelector(".description")).getText(), is("klik"));
    driver.close();
  }

  @Test
  public void clickTwice() {
    driver.get(BASE_URL);
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    assertThat(driver.findElement(By.id("clicks")).getText(), is("2"));
    assertThat(driver.findElement(By.cssSelector(".description")).getText(), is("kliky"));
    driver.close();
  }

  @Test
  public void clickMoreThanOnce() {
    driver.get(BASE_URL);
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    driver.findElement(By.id("clickMe")).click();
    assertThat(driver.findElement(By.id("clicks")).getText(), is("10"));
    assertThat(driver.findElement(By.cssSelector(".description")).getText(), is("klikov"));
    driver.close();
  }

  @Test
  public void clickCountPlusOne() {
    driver.get(BASE_URL);
    System.out.print(driver.findElement(By.id("clicks")).getText());
    Assert.assertEquals("Iniciální počet kliků", "0", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("1", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("2", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("3", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("4", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("5", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("6", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("7", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("8", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("9", driver.findElement(By.id("clicks")).getText());
    driver.findElement(By.id("clickMe")).click();
    Assert.assertEquals("10", driver.findElement(By.id("clicks")).getText());
  }

  @Test
  public void verifySklonovaniAPocetKliku() {
    driver.get(BASE_URL);
    Assert.assertEquals("Iniciální počet kliků", "0", driver.findElement(By.id("clicks")).getText());
    Assert.assertEquals("klikov", driver.findElement(By.cssSelector(".description")).getText());

    for (int i = 1; i < 11; i++) {
      driver.findElement(By.id("clickMe")).click();
      Assert.assertEquals(String.valueOf(i), driver.findElement(By.id("clicks")).getText());
      if (i == 1) {
        Assert.assertEquals("klik", driver.findElement(By.cssSelector(".description")).getText());
      }
      if (i >= 2 && i <= 4) {
        Assert.assertEquals("kliky", driver.findElement(By.cssSelector(".description")).getText());
      }
      if (i > 4) {
        Assert.assertEquals("klikov", driver.findElement(By.cssSelector(".description")).getText());
      }
    }
  }
}
