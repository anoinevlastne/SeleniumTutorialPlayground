import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckAtributeOfElement {
    private   WebDriver driver;
    private final String BASE_URL = "https://furbo.sk/playground/registracia.php";
    private String validEmail = "urych.s@gmail.com";
    private String failHlaska = "Registracia neuspesna!";
    private String validName = "Tomáš";
    private String validSurname = "Bledý";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void testCheckElementBorderColor () throws InterruptedException {
        String expectedClass = "has-error";
        driver.findElement(By.className("btn-success")).click();
        List<WebElement> formDivs = driver.findElements(By.xpath("//div[input]"));
        for (WebElement formDiv : formDivs){
            System.out.println(formDiv.getAttribute("class"));
            Assert.assertTrue(formDiv.getAttribute("class").contains(expectedClass));
            }
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/form/div[6]")).getAttribute("class").contains(expectedClass));
        }


    @Test
    public void testCheckElementAtributeAfterRefresh () throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-danger")).getText(), is(failHlaska));
        driver.navigate().refresh();
    }

    @After
    public void tearDown (){
        driver.close();
        driver.quit();

    }
}
