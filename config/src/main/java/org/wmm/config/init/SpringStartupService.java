package org.wmm.config.init;

import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;

@Component
public class SpringStartupService implements ApplicationContextAware, InitializingBean {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws NacosException, InterruptedException {
        Objects.requireNonNull(context);
        Map<String, ServiceStartUpLoader> serviceStartUpLoaderMap = context.getBeansOfType(ServiceStartUpLoader.class);
        if (!CollectionUtils.isEmpty(serviceStartUpLoaderMap)) {
            for (String beanName : serviceStartUpLoaderMap.keySet()) {
                serviceStartUpLoaderMap.get(beanName).load();
            }
        }
    }
}
