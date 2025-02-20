package ru.netology.springbootdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo.profile.DevProfile;
import ru.netology.springbootdemo.profile.ProductionProfile;
import ru.netology.springbootdemo.profile.SystemProfile;

@Configuration
public class JavaConfig{

    @Bean
    @ConditionalOnProperty(prefix="netology.profile", name="dev", havingValue="true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix="netology.profile", name="dev", havingValue="false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}