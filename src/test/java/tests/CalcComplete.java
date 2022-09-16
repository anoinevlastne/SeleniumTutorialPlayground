package tests;// Generated by Selenium IDE

import base.MainTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class CalcComplete extends MainTest {
  private final String BASE_URL = "https://furbo.sk/playground/kalkulacka.php";

  @Before
  public void setUp() {
    driver.get(BASE_URL);
  }

  @Test
  public void calcSumSpaghetti() {
    driver.findElement(By.id("firstInput")).sendKeys("5");
    driver.findElement(By.id("secondInput")).sendKeys("5");
    driver.findElement(By.id("count")).click();
    Assert.assertEquals("10",driver.findElement(By.id("result")).getText());
    driver.findElement(By.id("reset")).click();
    driver.findElement(By.id("firstInput")).sendKeys("1");
    driver.findElement(By.id("secondInput")).sendKeys("99");
    driver.findElement(By.id("count")).click();
    Assert.assertEquals("100",driver.findElement(By.id("result")).getText());
    driver.findElement(By.id("reset")).click();
    driver.findElement(By.id("firstInput")).sendKeys("-5");
    driver.findElement(By.id("secondInput")).sendKeys("13");
    driver.findElement(By.id("count")).click();
    Assert.assertEquals("8",driver.findElement(By.id("result")).getText());
  }
  @Test
  public void calcSum() {
    calc("13", "7", "count", "20");
    calc("10","11","count","21");
  }
  @Test
  public void calcDeduct() {
    calc("13", "7", "deduct", "6");
    calc("5", "5", "deduct", "0");
  }
  @Test
  public void calcReset() {
    calc("20", "10", "deduct", "10");
    driver.findElement(By.id("reset")).click();
    Assert.assertTrue(driver.findElement(By.id("firstInput")).getAttribute("value").isEmpty());
    Assert.assertTrue(driver.findElement(By.id("secondInput")).getAttribute("value").isEmpty());
    Assert.assertTrue(driver.findElement(By.id("result")).getText().isEmpty());
  }
  @Test
  public void calcInvalidInput() {
    String expectedClass = "has-error";
    driver.findElement(By.id("firstInput")).sendKeys("cpd");
    driver.findElement(By.id("secondInput")).sendKeys("10");
    driver.findElement(By.id("count")).click();
    Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='firstInput']]"))
            .getAttribute("class").contains(expectedClass));
    Assert.assertFalse(driver.findElement(By.xpath("//div[input[@id='secondInput']]"))
            .getAttribute("class").contains(expectedClass));
  }
  private void calc(String x, String x1, String count, String expected) {
    driver.findElement(By.id("reset")).click();
    driver.findElement(By.id("firstInput")).sendKeys(x);
    driver.findElement(By.id("secondInput")).sendKeys(x1);
    driver.findElement(By.id(count)).click();
    Assert.assertEquals(expected, driver.findElement(By.id("result")).getText());
  }
}