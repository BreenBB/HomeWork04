package utils;

import org.openqa.selenium.Capabilities;

public class CapabilityFactory {

    private Capabilities capabilities;// свойства браузера

    public Capabilities getCapabilities(String browser) {
        return OptionsManager.getChromeOptions();
    }

}
