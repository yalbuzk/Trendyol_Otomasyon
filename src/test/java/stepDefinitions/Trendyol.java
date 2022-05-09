package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class    Trendyol {
    private WebDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("www.trendyol.com sitesine giris yapilir.")
    public void https_www_trendyol_com_sitesine_giris_yapilir() {
        driver.get("https://www.trendyol.com/");

    }
    @When("Urun arama alanina masa ustu bilgisayar yazilir.")
    public void urun_arama_alanina_masa_ustu_bilgisayar_yazilir() {
        driver.findElement(By.xpath("//input[@class=\"search-box\"]")).sendKeys("bilgisayar");
        WebElement textbox = driver.findElement(By.id("//div[@class=\"search-box-container\"]"));
        textbox.sendKeys(Keys.ENTER);
    }

    @When("Bir urun secilir.")
    public void bir_urun_secilir() {
        driver.findElement(By.xpath("//div[@class=\"prdct-cntnr-wrppr\"]/div[1]")).click();
    }

    @And("Sepete ekle butonuna tiklanir.")
    public void sepete_ekle_butonuna_tiklanir() {
        driver.findElement(By.xpath("//div[@class=\"add-to-basket-button-text\"]")).click();
    }

    @And("Sepetim tiklanir.")
    public void sepetim_tiklanir() {
        //a[@class="link account-basket"]
        driver.findElement(By.xpath("//a[@class=\"link account-basket\"]")).click();
    }

    @And("Sepetteki urun adinin dogru oldugu tespit edilir.")
    public void sepetteki_urun_adinin_dogru_oldugu_tespit_edilir() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//p[@class=\"pb-item\"]"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Macbook Air 13'' M1 8gb 256gb Ssd Uzay Grisi");
    }
    @And("Cop Sepeti butonuna basilir.")
    public void cop_sepeti_butonuna_basilir() {
        driver.findElement(By.xpath("//i[@class=\"i-trash\"]")).click();

    }
    @And("Acilan Pop-up da sil butonuna basilir.")
    public void acilan_pop_up_da_sil_butonuna_basilir() {
        driver.findElement(By.xpath("//div[@class=\"pb-item-remove-confirmation-modal-footer\"]/div[1]/button[2]")).click();

    }

    @And("Daha sonra Sepetim tiklanir.")
    public void daha_sonra_sepetim_tiklanir() {
        //a[@class="link account-basket"]
        driver.findElement(By.xpath("//a[@class=\"link account-basket\"]")).click();
    }

    @Then("Sepette ilgili urunun bulunmadigi kontrol edilir.")
    public void sepette_ilgili_urunun_bulunmadigi_kontrol_edilir() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//span[.='Sepetinde ürün bulunmamaktadır.']"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Sepetinde ürün bulunmamaktadır.");
    }


}
