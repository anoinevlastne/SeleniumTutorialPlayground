// Generated by Selenium IDE

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class RadioButtonConchita {
  private WebDriver driver;
  private Map<String, Object> vars;
  private final String BASE_URL = "https://furbo.sk/playground/zenaalebomuz.php";
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void ConchitaMan() {
    driver.get(BASE_URL);
    driver.findElement(By.xpath("/html/body/div/div/div/label[1]/input")).click();
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h1")).getText(),"It's wurst");

  }

  @Test
  public void ConchitaWoman() {
    driver.get(BASE_URL);
    driver.findElement(By.xpath("/html/body/div/div/div/label[2]/input")).click();
    Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h1")).getText(),"It's conchita");

  }

  @Test
  public void ConchitaRadioButtonSelectedCheck() {
    driver.get(BASE_URL);
    Assert.assertFalse(driver.findElement(By.xpath("/html/body/div/div/div/label[1]/input")).isSelected());
    Assert.assertFalse(driver.findElement(By.xpath("/html/body/div/div/div/label[2]/input")).isSelected());

    driver.findElement(By.xpath("/html/body/div/div/div/label[1]/input")).click();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/label[1]/input")).isSelected());
    Assert.assertFalse(driver.findElement(By.xpath("/html/body/div/div/div/label[2]/input")).isSelected());

    driver.findElement(By.xpath("/html/body/div/div/div/label[2]/input")).click();
    Assert.assertFalse(driver.findElement(By.xpath("/html/body/div/div/div/label[1]/input")).isSelected());
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/label[2]/input")).isSelected());
  }

  @After
  public void tearDown() {
    driver.quit();
    }
  }

