// Generated by Selenium IDE

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalcSumTest extends MainTest {
  private final String BASE_URL = "https://furbo.sk/playground/kalkulacka.php";
  @Before
  public void setUp1() {
    driver.get(BASE_URL);
  }
  @Test
  public void calcSum() {
    driver.findElement(By.linkText("Kalkulacka")).click();
    driver.findElement(By.id("firstInput")).click();
    driver.findElement(By.id("firstInput")).sendKeys("5");
    driver.findElement(By.id("secondInput")).click();
    driver.findElement(By.id("secondInput")).sendKeys("16");
    driver.findElement(By.id("count")).click();
    assertThat(driver.findElement(By.id("result")).getText(), is("21"));
  }
}
