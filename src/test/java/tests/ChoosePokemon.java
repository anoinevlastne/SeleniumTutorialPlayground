package tests;// Generated by Selenium IDE

import base.MainTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

public class ChoosePokemon extends MainTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private final String BASE_URL = "https://furbo.sk/playground/vybersi.php";

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void selectDropdownAndVerify() {
    driver.get(BASE_URL);

    new Select(driver.findElement(By.className("form-control"))).selectByValue("01");
    driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText().contains("Charmander"));

    new Select(driver.findElement(By.className("form-control"))).selectByVisibleText("Pikachu");
    driver.findElement(By.xpath("//div/h3")).getText();
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText().contains("Pikachu"));

  }
}