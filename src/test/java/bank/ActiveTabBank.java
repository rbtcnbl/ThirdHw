package bank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActiveTabBank extends GeneralBank {

@FindBy(xpath = "//input[contains(@name, 'female')]")
public WebElement genderBtn;

@FindBy(xpath = "//section[contains(@class, 'b-form-section')][2]//input[contains(@placeholder, 'Имя')]")
public WebElement name;

@FindBy(xpath = "//span[contains(text(), 'Продолжить')]")
public WebElement continueBtn;


    public String fillInput(String numbOfSection, String name, String textToFill){
        String path = String.format("//section[contains(@class, 'b-form-section')][%s]//input[contains(@name, '%s')]", numbOfSection, name);
        driver.findElement(By.xpath(path)).sendKeys(textToFill);
        return driver.findElement(By.xpath(path)).getAttribute("value placeholder");
    }

    public String Comments(String numbOfSection, String placeholder, String text) {
        String path = String.format("//section[contains(@class, 'b-form-section')][%s]//textarea[contains(@placeholder, '%s')]", numbOfSection, placeholder);
        driver.findElement(By.xpath(path)).sendKeys(text);
        return driver.findElement(By.xpath(path)).getAttribute("value");
    }



}
