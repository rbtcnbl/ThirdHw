package bank;

import core.Init;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralBank {
    WebDriver driver;
    WebDriverWait wait;

    public GeneralBank(){
        this.driver = Init.driver;
        new WebDriverWait(driver, 5, 200);
        PageFactory.initElements(driver, this);

    }

//    public WebElement waitForReady(WebElement element){
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }

    @FindBy(xpath = "//section[contains(@class, 'b-active-tab')]")

    public WebElement activeTab;

    @FindBy(xpath = "//section[contains(@class, 'b-form-section')][2]")
    public WebElement bFormSection;

    @FindBy (xpath = "//*[text() = 'Заполнены не все обязательные поля']")
    public WebElement aser;


    public void waitSectionToDownload() {
        WebDriverWait wait = new WebDriverWait(driver, 5000, 200);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(activeTab, "class"));
        wait.until(ExpectedConditions.visibilityOf(bFormSection));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", activeTab);
    }

    public void findErrore(){
        Assert.assertTrue(aser.isEnabled());
    }
}
