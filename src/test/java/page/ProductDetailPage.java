package page;

import com.thoughtworks.gauge.Step;
import driver.BaseTest;
import methods.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDetailPage extends BaseTest {

    public BaseSteps baseSteps;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public ProductDetailPage() throws IOException {
        PageFactory.initElements(driver, this);
        this.baseSteps = new BaseSteps();
    }


    @FindBy(xpath = "//div[@data-test-id='has-review']")
    public WebElement assessments;

    @FindBy(css = ".hermes-Sort-module-Zwr_VRf_e4tZXl5J1PgT")
    public WebElement orderBy;

    @FindBy(css = ".thumbsUp.hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV")
    public WebElement thumpsUp;

    @FindBy(xpath = "//div[@data-test-id='price-current-price']")
    public WebElement otherPrice1;

    @FindBy(xpath = "//div[@data-test-id='price-current-price']/../following-sibling::button")
    public WebElement otherPriceCart1;

    @FindBy(xpath = "(//div[@data-test-id='price-current-price']/../following-sibling::button)[2]")
    public WebElement otherPriceCart2;

    @FindBy(xpath = "(//div[@data-test-id='price-current-price'])[2]")
    public WebElement otherPrice2;

    @FindBy(xpath = "//div[@data-test-id='default-price']//span")
    public WebElement productPrice;

    @FindBy(xpath = "(//div[@data-test-id='checkout-price']//div)[2]")
    public WebElement productDiscountPrice;

    @FindBy(xpath = "//button[@data-test-id='addToCart']")
    public WebElement productAddToCart;

    @Step("Değerlendirmeler butonuna tıklanır")
    public void clickAssessments() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-test-id='has-review']")));
        baseSteps.waitBySeconds(1);
        if (assessments.isDisplayed()){
            assessments.click();
            logger.info("Değerlendirmeler butonuna tıklandı");
        }
        else {
            driver.quit();
        }
    }

    @Step("Sırala butonuna tıklanır")
    public void clickOrderBy() {
        baseSteps.waitBySeconds(1);
        orderBy.click();
        logger.info("Sırala butonuna tıklandı");
    }

    @Step("Yorum yoksa test sonlandırılır")
    public void exitTestIfNoComment() {
        if(!thumpsUp.isDisplayed())
        {
            driver.quit();
            logger.info("Yorum yok. Test Sonlandirildi!");
        }
    }

    @Step("Ürün sepete eklenir")
    public void addToCart() {
        productAddToCart.click();
        logger.info("Secili urun sepete eklendi");
    }

    @Step("Diğer satıcı fiyatları karşılaştırılır en uygun fiyat sepete eklenir")
    public void sortByPrice(){
        baseSteps.waitBySeconds(2);
        List<Double> priceList = new ArrayList<>();
        String priceOne;
        String priceTwo;
        Double price2 = null;
        Double price1 = null;

        try
        {
            priceOne = otherPrice1.getText();
            priceOne = priceOne.replace(".", "");
            priceOne = priceOne.replace(",", ".");
            priceOne = priceOne.replace(" TL", "");
            price1 = Double.parseDouble(priceOne);
            System.out.println("price1 değer: " + price1);
            priceList.add(price1);
        }
        catch (NoSuchElementException e) {
            logger.info("Diger satici bulunamadi!");
        }

        baseSteps.waitBySeconds(2);

        try {
            priceTwo = otherPrice2.getText();
            priceTwo = priceTwo.replace(".", "");
            priceTwo = priceTwo.replace(",", ".");
            priceTwo = priceTwo.replace(" TL", "");
            price2 = Double.parseDouble(priceTwo);
            System.out.println("price2 değer: " + price2);
            priceList.add(price2);
        }
        catch (NoSuchElementException e) {
            logger.info("Diger satici bulunamadi!");
        }

        baseSteps.waitBySeconds(1);

        try {
            String priceProduct = productPrice.getText();
            priceProduct = priceProduct.replace(".", "");
            priceProduct = priceProduct.replace(",", ".");
            priceProduct = priceProduct.replace(" TL", "");
            Double priceProd = Double.parseDouble(priceProduct);
            System.out.println("priceProd değer: " + priceProd);
            priceList.add(priceProd);
        }
        catch (NoSuchElementException e){
            String priceProduct = productDiscountPrice.getText();
            priceProduct = priceProduct.replace(".", "");
            priceProduct = priceProduct.replace(",", ".");
            priceProduct = priceProduct.replace(" TL", "");
            Double priceProd = Double.parseDouble(priceProduct);
            System.out.println("priceProd indirimli değer: " + priceProd);
            priceList.add(priceProd);
        }

        Collections.sort(priceList);

        if(priceList.get(0) == price1){
            otherPriceCart1.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id='addToCart']")));
            productAddToCart.click();
            logger.info("Ilk diger urun sepete eklendi");
        }
        else if(priceList.get(0) == price2){
            otherPriceCart2.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-test-id='addToCart']")));
            productAddToCart.click();
            logger.info("Ikinci diğer urun sepete eklendi");

        }
        else {
            productAddToCart.click();
            logger.info("Secili urun sepete eklendi");
        }

        priceList.clear();

    }

}
