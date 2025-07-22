package config;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    @Getter
    protected static final BrowserStackConfig configuredDriver =
            ConfigFactory.create(BrowserStackConfig.class,System.getProperties());
}
