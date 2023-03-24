package org.wmm.config.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * url白名单实体类
 * {@link PropertySource#value()}从左往右顺序读取，最后以最右边有效文件为准，若配置的文件路径都不存在，则报错
 */
@Data
@Component
//@PropertySource(value = {"classpath:whitelist-url.properties", "file:/usr/icssas/conf/whitelist-url.properties"}, ignoreResourceNotFound = true)
//@ConfigurationProperties(prefix = "whitelist")
public class UrlWhitelist {
    private List<String> urls = new ArrayList<>();

  /*  @PostConstruct
    public void log() {
        if (CollectionUtils.isEmpty(urls)) {
            throw new NullPointerException("whitelist-url.properties文件不存在");
        }
    }*/
}
