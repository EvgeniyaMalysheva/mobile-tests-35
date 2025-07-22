package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import config.ConfigProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    protected static final BrowserStackConfig config = ConfigProvider.getConfiguredDriver();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("app", config.app()); // Замените на реальный app ID
        caps.setCapability("deviceName", config.deviceName());
        caps.setCapability("platformName", config.platformName());
        caps.setCapability("platformVersion", config.platformVersion());
        caps.setCapability("browserstackLocal", true);

        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("userName", config.userName());
        bstackOptions.setCapability("accessKey", config.accessKey());
        bstackOptions.setCapability("projectName", config.projectName());
        bstackOptions.setCapability("buildName", config.buildName());
        bstackOptions.setCapability("sessionName", config.sessionName());
        bstackOptions.setCapability("video", true);

        caps.setCapability("bstack:options", bstackOptions);


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.URL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
