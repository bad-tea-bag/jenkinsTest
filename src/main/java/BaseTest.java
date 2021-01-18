import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected static final Logger LOG = AqualityServices.getLogger();
    protected Steps step = new Steps();
    private int stepNumber;

    @BeforeMethod
    public void beforeMethod() {
        stepNumber = 1;
        AqualityServices.getBrowser().goTo(Constants.URL);
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().waitForPageToLoad();
        step.checkTinyMCEPopupAndConfirmIfPresents();
    }

    @AfterMethod
    public void afterMethod() {
        AqualityServices.getBrowser().quit();
    }

    protected void logStep(String message) {
        String format = "Step %d: %s";
        LOG.info(String.format(format, stepNumber, message));
        stepNumber++;
    }
}