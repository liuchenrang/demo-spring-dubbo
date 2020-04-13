package org.people.xinghuo.order.config;

import org.people.xinghuo.service.DemoService;
import org.apache.dubbo.config.*;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 */
@Configuration
public class DubboConfig {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName("orderProvider");
        return config;
    }
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("nacos://localhost:8848");
        registryConfig.setAddress("redis://localhost:6379");

        return registryConfig;
    }
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        protocolConfig.setServer("tomcat");
        protocolConfig.setPort(8099);
        return protocolConfig;
    }

    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public ReferenceConfig<DemoService> services(){
        ReferenceConfig<DemoService> service = new ReferenceConfig<>();
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(applicationConfig());
        bootstrap.monitor(monitorConfig());
        bootstrap.registry(registryConfig());
        bootstrap.protocol(protocolConfig());
        service.setBootstrap(bootstrap);
        // 多个注册中心可以用setRegistries()
        service.setInterface(DemoService.class);
        service.setVersion("1.0.0");
        service.setCheck(false);
        return service;
    }

}

