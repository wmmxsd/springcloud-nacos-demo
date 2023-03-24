package org.wmm.config.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wmm.config.model.MysqlConfig;

import java.util.Properties;

import static org.wmm.config.init.impl.ConfigLoader.DATA_ID;
import static org.wmm.config.init.impl.ConfigLoader.DEFAULT_GROUP;

@RestController
@RequestMapping("mysql-config")
public class MysqlConfigController {
    @Autowired
    private MysqlConfig mysqlConfig;

    @GetMapping("")
    public String helloWorld() {
        System.out.println("config: " + mysqlConfig);
        return mysqlConfig.toString();
    }

    @PostMapping("")
    public void changeConfig(String content) throws NacosException {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, "192.168.213.212:8848");
        properties.setProperty(PropertyKeyConst.NAMESPACE, "413386ae-22f2-4b3e-89c6-b79d3c514bb2");
        ConfigService configService = NacosFactory.createConfigService(properties);
        /*String content1 = "mysql:\n" +
                "  host: 192.168.119.213\n" +
                "  port: 22\n" +
                "  user: root\n" +
                "  passwd: 123456";*/
        configService.publishConfig(DATA_ID, DEFAULT_GROUP, content, ConfigType.YAML.getType());
    }
}
