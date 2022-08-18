package Tests;// Generated by Selenium IDE

import Base.MainTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
public class CalcMinusTest extends MainTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void calcMinus() {
    driver.get("https://furbo.sk/playground/");
    driver.findElement(By.linkText("Kalkulacka")).click();
    driver.findElement(By.id("firstInput")).click();
    driver.findElement(By.id("firstInput")).sendKeys("9");
    driver.findElement(By.id("secondInput")).click();
    driver.findElement(By.id("secondInput")).sendKeys("5");
    driver.findElement(By.id("deduct")).click();
    assertThat(driver.findElement(By.id("result")).getText(), is("4"));
    driver.close();
  }
}
