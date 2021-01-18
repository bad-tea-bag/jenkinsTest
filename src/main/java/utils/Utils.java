package utils;

import aquality.selenium.browser.AqualityServices;

public class Utils {
    public static int getRandomValue(int size) {
        int b = size - 1;
        return (int)(Math.random() * b);
    }

    public static String getRandomString(int length) {
        int minSymbol = 'A';
        int maxSymbol = 'z';
        int size = maxSymbol - minSymbol;
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomValue = getRandomValue(size);
            char randomChar = (char)(randomValue + minSymbol);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public static void switchToFrame(String nameOrId) {
        AqualityServices.getBrowser().getDriver().switchTo().frame(nameOrId);
    }

    public static void switchToDefaultContent() {
        AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
    }
}