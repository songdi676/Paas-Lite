package com.songdi.paas.auth.server.runner;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.songdi.paas.auth.common.util.jwt.RsaKeyHelper;
import com.songdi.paas.auth.server.configuration.KeyConfiguration;

/**
 * @author ace
 * @create 2017/12/17.
 */
@Configuration
@Order(value = 1)
public class AuthServerRunner implements CommandLineRunner {
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    private static final String REDIS_SERVICE_PRI_KEY = "AG:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "AG:AUTH:CLIENT:PUB";
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化密钥");
        Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
        keyConfiguration.setUserPriKey(keyMap.get("pri"));
        keyConfiguration.setUserPubKey(keyMap.get("pub"));
        keyMap = RsaKeyHelper.generateKey(keyConfiguration.getServiceSecret());
        keyConfiguration.setServicePriKey(keyMap.get("pri"));
        keyConfiguration.setServicePubKey(keyMap.get("pub"));

    }
}
