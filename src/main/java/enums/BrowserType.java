package enums;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browserName;

    BrowserType(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserType() {
        return browserName;
    }

    public static BrowserType getBrowserTypeByName(String browserName) {
        for (BrowserType browserType : values()) {
            if (browserType.getBrowserType().equals(browserName.toLowerCase())) {
                return browserType;
            }
        }
        throw new IllegalArgumentException("No browser found with name: " + browserName);
    }
}
