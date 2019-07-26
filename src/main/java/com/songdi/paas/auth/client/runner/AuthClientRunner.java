package com.songdi.paas.auth.client.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;

import com.songdi.paas.auth.client.config.UserAuthConfig;
import com.songdi.paas.auth.server.configuration.KeyConfiguration;

/**
 * 监听完成时触发
 *
 * @author ace
 * @create 2017/11/29.
 */
@Configuration
@Order(value = 2)
public class AuthClientRunner implements CommandLineRunner {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserAuthConfig userAuthConfig;
    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化加载用户pubKey");
        try {
            refreshUserPubKey();
        } catch (Exception e) {
            log.error("初始化加载用户pubKey失败,1分钟后自动重试!", e);
        }

    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void refreshUserPubKey() {
        this.userAuthConfig.setPubKeyByte(keyConfiguration.getUserPubKey());
    }

}