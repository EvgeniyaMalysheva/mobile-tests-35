package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/browserstack.properties"
})

public interface BrowserStackConfig extends Config {

    @Key("app")
    @DefaultValue("bs://sample.app")
    String app();

    @Key("deviceName")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String deviceName();

    @Key("platformName")
    @DefaultValue("Android")
    String platformName();

    @Key("platformVersion")
    @DefaultValue("12.0")
    String platformVersion();

    @Key("userName")
    @DefaultValue("${BROWSERSTACK_USERNAME}")
    String userName();

    @Key("accessKey")
    @DefaultValue("${BROWSERSTACK_ACCESS_KEY}")
    String accessKey();

    @Key("projectName")
    @DefaultValue("BrowserStack Sample")
    String projectName();

    @Key("buildName")
    @DefaultValue("browserstack-build-1")
    String buildName();

    @Key("sessionName")
    @DefaultValue("first_test")
    String sessionName();

    @Key("URL")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String URL();
}
