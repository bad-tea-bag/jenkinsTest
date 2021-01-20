package utils;
import aquality.selenium.browser.AqualityServices;
import constants.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import static aquality.selenium.browser.AqualityServices.getLogger;

public class ScreenShotUtils {
    public static File makeScreenshot() {
        getLogger().info("Making screenshot");
        TakesScreenshot scrShot = ((TakesScreenshot) AqualityServices.getBrowser().getDriver());
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String s = timestamp.toString().replace(":", "_");
        File destFile = new File(Constants.PATH_TO_SCREENSHOT + "Screenshot_" + s + Constants.PNG);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            getLogger().error("There is a problem during copying a file: " + e.getMessage());
        }
        return destFile;
    }
}