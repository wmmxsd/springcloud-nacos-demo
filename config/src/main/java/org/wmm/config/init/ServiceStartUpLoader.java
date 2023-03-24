package org.wmm.config.init;

import com.alibaba.nacos.api.exception.NacosException;

/**
 * <B>说明</B>:服务启动加载器。
 * <p>服务启动后会调用所有的加载器进行系统资源的加载。
 */
public interface ServiceStartUpLoader {
    /**
     * 加载动作。
     * <p>加载系统资源，系统数据等。
     */
    void load() throws NacosException, InterruptedException;
}
