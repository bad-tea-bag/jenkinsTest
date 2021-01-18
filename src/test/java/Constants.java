import utils.PropertyUtils;

public class Constants {
    public static final String URL = PropertyUtils.getValue("url");
    public static final String HEADING_TEXT = PropertyUtils.getValue("headingText");
    public static final Integer RANDOM_LENGTH = Integer.parseInt(PropertyUtils.getValue("stringLength"));
    public static final String IFRAME_ID = "mce_0_ifr";
    public static final String ATTRIBUTE_BOLD_BUTTON = "aria-pressed";
    public static final String EXPECTED_ATTRIBUTE_BOLD_VALUE = "true";
    public static final String TINY_MCE_ID = "mceu_31";
    public static final String CONTENT_ID = "content";
}