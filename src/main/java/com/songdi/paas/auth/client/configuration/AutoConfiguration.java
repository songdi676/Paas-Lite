package com.songdi.paas.auth.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.songdi.paas.auth.client.config.UserAuthConfig;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
public class AutoConfiguration {

    @Bean
    UserAuthConfig getUserAuthConfig() {
        return new UserAuthConfig();
    }

}
