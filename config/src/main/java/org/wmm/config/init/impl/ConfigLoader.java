package org.wmm.config.init.impl;


import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Component;
import org.wmm.config.init.ServiceStartUpLoader;

import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * 配置加载器
 */
@Component
public class ConfigLoader implements ServiceStartUpLoader {

    public static final String DATA_ID = "config-dev.yaml";
    public static final String DEFAULT_GROUP = "DEFAULT_GROUP";

    @Override
    public void load() throws NacosException {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, "192.168.213.212:8848");
        properties.setProperty(PropertyKeyConst.NAMESPACE, "413386ae-22f2-4b3e-89c6-b79d3c514bb2");
        ConfigService configService = NacosFactory.createConfigService(properties);

        String conf = configService.getConfigAndSignListener(DATA_ID, DEFAULT_GROUP, 1000, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                // 监听配置
                System.out.println("config changed: " + configInfo);
            }
        });

        System.out.println("config:");
        System.out.println(conf);
    }
}
