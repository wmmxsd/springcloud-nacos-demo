package org.wmm.config.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "mysql")
@Data
public class MysqlConfig {
    private String host;
    private Integer port;
    private String user;
    private String passwd;
}
