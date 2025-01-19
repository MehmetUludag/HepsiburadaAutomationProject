package page;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import methods.BaseSteps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseTest {

    public BaseSteps baseSteps;

    public HomePage() throws IOException {
        PageFactory.initElements(driver, this);
        this.baseSteps = new BaseSteps();
    }

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    public WebElement searchInput;

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']/..")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[text()='Kabul et']")
    public WebElement cookieAccept;


    @Step("Çerez popupı açıldıysa kapatılır")
    public void closeCookiesPopup() {
        if (cookieAccept.isDisplayed())
        {
            baseSteps.waitBySeconds(1);
            cookieAccept.click();
            logger.info("Çerez popup kapatıldı");
        }
    }

    @Step("Arama kutusuna <urun> girilir")
    public void searchInput(String urun) {
        baseSteps.waitBySeconds(1);
        searchBtn.click();
        baseSteps.waitBySeconds(1);
        searchInput.sendKeys(urun);
        logger.info("{} elementine {} texti yazıldı.", searchInput, urun);
    }

    @Step("Arama kutusunda enter'a tıklanır")
    public void enterSearch() {
        baseSteps.waitBySeconds(1);
        searchInput.sendKeys(Keys.RETURN);
        logger.info("Arama kutusunda enter'a tıklanır");
    }


}
