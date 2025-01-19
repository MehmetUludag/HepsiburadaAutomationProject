package page;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import methods.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ListPage extends BaseTest {

    public BaseSteps baseSteps;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public ListPage() throws IOException {
        PageFactory.initElements(driver, this);
        this.baseSteps = new BaseSteps();
    }

    @FindBy(css = ".productListContent-zAP0Y5msy8OHn5z7T_K_")
    public WebElement productElement;

    @FindBy(xpath = "//button[@data-test-id='addToCart']")
    public WebElement addToCart;

    @FindBy(css = ".moria-Popover-dANpLo.bKhk.sdheiwq5j0j")
    public WebElement quickFilterPopup;


    @Step("Ürün listesinde rastgele birine tikla")
    public void clickRandomProduct() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".productListContent-zAP0Y5msy8OHn5z7T_K_")));
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".productListContent-zAP0Y5msy8OHn5z7T_K_"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        logger.info("{} elementi rastgele tiklandi", productElement);
        baseSteps.waitBySeconds(1);
    }




}
