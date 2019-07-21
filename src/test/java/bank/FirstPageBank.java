package bank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class FirstPageBank extends GeneralBank {


    @FindBy(xpath = "//span[contains(text(), 'Страхование')]")
    public WebElement insuranceBtn;

    @FindBy(xpath = "//li[contains(@class, 'lg-menu__sub-item')]/a[contains(text(), 'Путешествия и покупки')]")
    public WebElement arrivalsBtn;

    @FindBy(xpath = "//div[contains(@class, 'sbrf-rich-outer')]/following::a[1]")
    public WebElement straxBtn;

    @FindBy(xpath = "//section[contains(@class, 'b-form-section')][2]//div[contains(@class, 'b-form-prog-box')][1]")
    public WebElement bformSection;

    @FindBy(xpath = "//span[contains(text(), 'Оформить')]")
    public WebElement issueBtn;

    public FirstPageBank insurance() {
        insuranceBtn.click();
        arrivalsBtn.click();
        return new FirstPageBank();
    }

    public FirstPageBank issueInsurance(){
        bformSection.click();
        issueBtn.click();
        return new FirstPageBank();
    }

    public void OpenNewWindow(){
        Set<String> h1 = driver.getWindowHandles();
        straxBtn.click();
        Set<String> h2 = driver.getWindowHandles();
        h2.removeAll(h1);
        String h3 = h2.iterator().next();
        driver.switchTo().window(h3);

    }
}
