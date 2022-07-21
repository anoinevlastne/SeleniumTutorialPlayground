import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationComplete {
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
    public void testRegistrationNegativeNotMatchingPasswords () throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("comp");
        driver.findElement(By.name("password-repeat")).sendKeys("comp1");
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-danger")).getText(), is(failHlaska));
    }
    @Test
    public void testRegistrationNegativeSomRobotNotClicked () throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("comp");
        driver.findElement(By.name("password-repeat")).sendKeys("comp");
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-danger")).getText(), is(failHlaska));
    }
    @Test
    public void testMissingAllInputs () throws InterruptedException {
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-danger")).getText(), is(failHlaska));
    }
    @Test
    public void testRegistrationMissingPasswords () throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-danger")).getText(), is(failHlaska));
    }
    @Test
    public void testRegistrationSuccess () throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(validEmail);
        driver.findElement(By.name("name")).sendKeys(validName);
        driver.findElement(By.name("surname")).sendKeys(validSurname);
        driver.findElement(By.name("password")).sendKeys("Comp129!");
        driver.findElement(By.name("password-repeat")).sendKeys("Comp129!");
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.className("btn-success")).click();
        assertThat(driver.findElement(By.className("alert-success")).getText(), is("Registracia uspesna!"));
    }
    @After
    public void tearDown (){
        driver.close();
        driver.quit();

    }
}
