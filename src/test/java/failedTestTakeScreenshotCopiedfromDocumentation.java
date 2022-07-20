// Generated by Selenium IDE

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class failedTestTakeScreenshotCopiedfromDocumentation {
  private WebDriver driver;
  private Map<String, Object> vars;
  private final String BASE_URL = "https://furbo.sk/playground/vybersi.php";
  JavascriptExecutor js;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }

  @Test
  public void failedTest() {
    driver.get(BASE_URL);
    new Select(driver.findElement(By.xpath("/html/body/div/div[1]/select"))).selectByVisibleText("Pikachu");
    String actualTitle = driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText();
    Assert.assertTrue(actualTitle.contains("Pikachu"));

    new Select(driver.findElement(By.xpath("/html/body/div/div[1]/select"))).selectByVisibleText("Pikachu");
    actualTitle = driver.findElement(By.xpath("/html/body/div/div[2]/h3")).getText();
    Assert.assertTrue(actualTitle.contains("Charmander"));
  }

  @After
  public void screenShot(ITestResult result){
//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
    if(ITestResult.FAILURE==result.getStatus()){
      try{
// To create reference of TakesScreenshot
        TakesScreenshot screenshot=(TakesScreenshot)driver;
// Call method to capture screenshot
        File src=screenshot.getScreenshotAs(OutputType.FILE);
// Copy files to specific location
// result.getName() will return name of test case so that screenshot name will be same as test case name
        FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
        System.out.println("Successfully captured a screenshot");
      }catch (Exception e){
        System.out.println("Exception while taking screenshot "+e.getMessage());
      }
    }
    driver.quit();
  }
}