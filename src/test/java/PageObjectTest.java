import bank.ActiveTabBank;
import bank.FirstPageBank;
import bank.GeneralBank;
import core.Init;
import org.junit.Test;

public class PageObjectTest {

    @Test
    public void openBankPage() {
        Init.startBrowser("http://www.sberbank.ru/ru/person");


        FirstPageBank firstPageBank = new FirstPageBank();
        firstPageBank.insurance()
                .OpenNewWindow();
        firstPageBank.waitSectionToDownload();
        firstPageBank.issueInsurance();

        ActiveTabBank activeTabBank = new ActiveTabBank();
        activeTabBank.fillInput("1", "insured0_surname", "Gorbulina");
        activeTabBank.fillInput("1", "insured0_name", "Alesya");
        activeTabBank.fillInput("1", "insured0_birthDate", "28111997");
        activeTabBank.fillInput("2", "surname", "Русанова");
        activeTabBank.name.sendKeys("Мария");
        activeTabBank.fillInput("2", "middlename", "Леонидовна");
        activeTabBank.fillInput("2", "birthDate", "14071997");
        activeTabBank.genderBtn.click();
        activeTabBank.fillInput("3", "passport_series", "1234");
        activeTabBank.fillInput("3", "passport_number", "123456");
        activeTabBank.fillInput("3", "issueDate", "20102015");
        activeTabBank.Comments("3", "Кем выдан","В ЦАО гор. Москвы");

        activeTabBank.continueBtn.click();
        activeTabBank.findErrore();


        Init.afterClass();

    }

}
