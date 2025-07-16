package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
//        caps.setCapability("browserstack.user", "bsuser_sLVSk3");
//        caps.setCapability("browserstack.key", "rZ3tApfRNDyqQViByc5f");

        // Set URL of the application under test
//        caps.setCapability("app", "bs://sample.app");

        // Specify device and os_version for testing
//        caps.setCapability("device", "Google Pixel 6");
//        caps.setCapability("deviceName", "Google Pixel 6");

//        caps.setCapability("os_version", "12.0");
//        caps.setCapability("platformVersion", "12.0");

        caps.setCapability("app", "bs://sample.app"); // Замените на реальный app ID
        caps.setCapability("deviceName", "Samsung Galaxy S22 Ultra");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0");
        caps.setCapability("browserstackLocal", true);

        MutableCapabilities bstackOptions = new MutableCapabilities();
        bstackOptions.setCapability("userName", "bsuser_sLVSk3");
        bstackOptions.setCapability("accessKey", "rZ3tApfRNDyqQViByc5f");
        bstackOptions.setCapability("projectName", "BrowserStack Sample");
        bstackOptions.setCapability("buildName", "browserstack-build-1");
        bstackOptions.setCapability("sessionName", "first_test");
        bstackOptions.setCapability("video", true);

        caps.setCapability("bstack:options", bstackOptions);

//
//        // Set other BrowserStack capabilities
//        caps.setCapability("project", "First Java Project");
//        caps.setCapability("build", "browserstack-build-1");
//        caps.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
