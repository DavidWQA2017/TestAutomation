import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/08/2017.
 */
public class AuotTHomeBuying
{
    @FindBy(xpath = "//*[@id=\"js-known-search-advanced\"]/div[1]/div[1]/input")
    private WebElement postcodeField;

    @FindBy(xpath = "//*[@id=\"js-known-search-advanced\"]/div[2]/input")
    private WebElement keyWordField;

    @FindBy(xpath = "//*[@id=\"js-known-search-advanced\"]/div[1]/button")
    private WebElement searchCarsButton;

    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/div/div/h1")
    private WebElement carsFoundDisplay;

    @FindBy(xpath = "//*[@id=\"js-known-search-advanced\"]/div[1]/div[2]/div[1]/label/p")
    private WebElement postcodeRequirementText;

    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/ul/li[7]/div/button/span/span[2]/span[1]")
    private WebElement filterByPriceDropDown;


    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/ul/li[6]/div/div/div/div[1]/select")
    private WebElement fromField;

    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/ul/li[6]/div/div/div/div[2]")
    private WebElement toField;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/header/div/label/div/div/select")
    private WebElement sortByDropDown;

    @FindBy(xpath = "//*[@id=\"201707207567047\"]/article/section[2]/a/div")
    private WebElement carAmountDisplay;





    public void enterPostcode(String postcode)
    {
        postcodeField.sendKeys(postcode);
    }

    public void enterKeyWord(String keyword)
    {
        keyWordField.sendKeys(keyword);
    }

    public void clickSearchCarsButton()
    {
        searchCarsButton.click();
    }

    public String getCarsFoundFrDisplay()
    {
        String carsFound = carsFoundDisplay.getText();
        return carsFound;
    }

    public String getPostcodeRequirementText()
    {
        String requirmentText = postcodeRequirementText.getText();
        return requirmentText;
    }

    public void clickFilterByPrice()
    {
        filterByPriceDropDown.click();
    }

    public void enterMinPrice(String minPrice)
    {
        fromField.sendKeys(minPrice);
    }

    public void enterMaxPrice(String maxPrice)
    {
        toField.sendKeys(maxPrice);
    }

    public void clickSortBy()
    {
        sortByDropDown.click();
    }

    public String getCarAmountDisplay()
    {
        String carAmount = carAmountDisplay.getText();
        return  carAmount;
    }

}
