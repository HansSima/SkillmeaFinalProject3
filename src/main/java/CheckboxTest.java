import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CheckboxTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp(){
        driver.close();
        driver.quit();
    }

    @Given("Uzivatel se nachazi na strance s checkboxy")
    public void uzivatelSeNachaziNaStranceSCheckboxy() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
    }

    @When("Uzivatel klikne na tlacitko plus pro rozbaleni checkboxu")
    public void uzivatelKlikneNaTlacitkoPlusProRozbaleniCheckboxu() {
        driver.findElement(By.xpath("//li[@id='bs_1']/span")).click();
    }

    @And("Uzivatel klikne na checkbox s id {string}")
    public void uzivatelKlikneNaCheckboxSId(String idPrvku) {
        driver.findElement(By.id(idPrvku)).click();
    }

    @Then("Nadrazeny checkbox s id {string} je zaskrtnut")
    public void nadrazenyCheckboxSIdJeZaskrtnut(String idPrvku) {
        assertTrue(driver.findElement(By.id(idPrvku)).isSelected());
    }

    @Then("Nadrazeny checkbox s id {string} je odskrtnut")
    public void nadrazenyCheckboxSIdJeOdskrtnut(String idPrvku) {
        assertFalse(driver.findElement(By.id(idPrvku)).isSelected());
    }
}
