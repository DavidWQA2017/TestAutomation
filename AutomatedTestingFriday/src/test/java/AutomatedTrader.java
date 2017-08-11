import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 11/08/2017.
 */
public class AutomatedTrader
{

    @FindBy(xpath = "//*[@id=\"home\"]/header/nav[1]/ul/li[1]/a")
    private WebElement carsButton;

    @FindBy(xpath = "//*[@id=\"js-header-nav\"]/ul/li[1]/a")
    private WebElement buyNewAndUsedButton;






    public void clickcarButton()
    {
        carsButton.click();
    }

    public void clickBuyNewAndUsedButton()
    {
        buyNewAndUsedButton.click();
    }

    public void clickFindCarButton()
    {

    }


}
