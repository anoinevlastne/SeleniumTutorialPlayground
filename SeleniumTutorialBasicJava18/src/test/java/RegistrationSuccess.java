import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationSuccess {
    private   WebDriver driver;
    private final String BASE_URL = "https://furbo.sk/playground/registracia.php";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void test () throws InterruptedException {
        driver.get(BASE_URL);
        driver.findElement(By.name("email")).sendKeys("urych.s@gmail.com");
        driver.findElement(By.name("name")).sendKeys("Tomáš");
        driver.findElement(By.name("surname")).sendKeys("Bledý");
        driver.findElement(By.name("password")).sendKeys("Comp129!");
        driver.findElement(By.name("password-repeat")).sendKeys("Comp129!");
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-success")).getText(), is("Registracia uspesna!"));


    }
    @After
    public void tearDown (){
        driver.close();

    }
}
