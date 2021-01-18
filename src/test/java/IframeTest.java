import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Utils;

import static utils.Utils.switchToDefaultContent;
import static utils.Utils.switchToFrame;

public class IframeTest extends BaseTest {
    private static final SoftAssert SOFT_ASSERT = new SoftAssert();

    @Test
    public void iFrameTest() {
        logStep("Checking text on the page " + Constants.URL);
        SOFT_ASSERT.assertEquals(step.getHeadingText(), Constants.HEADING_TEXT, "The text on the page equals expected text");

        logStep("Clearing the input field and entering random string");
        switchToFrame(Constants.IFRAME_ID);
        String randomString = Utils.getRandomString(Constants.RANDOM_LENGTH);
        step.insertToTextybox(randomString);
        SOFT_ASSERT.assertEquals(step.getInsertedText(), randomString, "Text in the input field equals the random generated text");

        logStep("Highlighting the entered text and pressing the 'B' button");
        switchToDefaultContent();
        step.highlightInBoldSelectedText();
        SOFT_ASSERT.assertEquals(step.getAttributeValueForBoldButton(Constants.ATTRIBUTE_BOLD_BUTTON), Constants.EXPECTED_ATTRIBUTE_BOLD_VALUE, "Text is in bold");
        SOFT_ASSERT.assertAll();
    }
}