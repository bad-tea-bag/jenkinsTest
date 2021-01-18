import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class Steps {
    private final IframePage iframePage = new IframePage(By.id(Constants.CONTENT_ID), "IFrame page");

    public void insertToTextybox(String text) {
        iframePage.insertToTextBox(text);
    }

    public String getHeadingText() {
        return iframePage.getHeaderText();
    }

    public String getInsertedText() {
        return iframePage.getInsertedText();
    }

    public void highlightInBoldSelectedText() {
        iframePage.clickButtonEdit();
        iframePage.clickButtonSelectAll();
        iframePage.clickButtonBold();
    }

    public String getAttributeValueForBoldButton(String attribute) {
        return iframePage.getAttributeBoldButton(attribute);
    }

    public void checkTinyMCEPopupAndConfirmIfPresents() {
        By popupLocator = By.id(Constants.TINY_MCE_ID);
        ExpectedCondition<Boolean> condition = ExpectedConditions.invisibilityOfElementLocated(popupLocator);
        Boolean invisibleElement = condition.apply(getBrowser().getDriver());
        if (invisibleElement != null && !invisibleElement) {
            iframePage.clickButtonOk();
        }
    }
}