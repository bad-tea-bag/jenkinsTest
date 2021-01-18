import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;


public class IframePage extends Form {

    public IframePage(By locator, String name) {
        super(locator, name);
    }

    @Getter
    private final ILabel headingText = getElementFactory().getLabel(By.tagName("h3"), "Header text");
    @Getter
    private final ITextBox txbInput = getElementFactory().getTextBox(By.tagName("p"), "Input field");
    @Getter
    private final IButton btnEdit = getElementFactory().getButton(By.xpath("//span[text()='Edit']"), "Edit");
    @Getter
    private final IComboBox selectAllOptions = getElementFactory().getComboBox(By.xpath("//div[text()='Select all']"), "Select all");
    @Getter
    private final IButton btnBold = getElementFactory().getButton(By.xpath("//button[@aria-label='Bold']"), "Bold");
    @Getter
    private final IButton btnOk = getElementFactory().getButton(By.id("mceu_34"), "Ok button on TinyMCE popup");

    public void insertToTextBox(String text) {
        getTxbInput().clearAndType(text);
    }

    public String getInsertedText() {
        return getTxbInput().getText();
    }

    public String getHeaderText() {
        return getHeadingText().getText();
    }

    public void clickButtonEdit() {
        getBtnEdit().click();
    }

    public void clickButtonBold() {
        getBtnBold().click();
    }

    public void clickButtonSelectAll() {
        getSelectAllOptions().clickAndWait();
    }

    public String getAttributeBoldButton(String attribute) {
        return getBtnBold().getAttribute(attribute);
    }

    public void clickButtonOk() {
        getBtnOk().clickAndWait();
    }
}