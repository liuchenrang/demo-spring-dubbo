package org.people.xinghuo.config;

import org.apache.dubbo.config.*;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.people.xinghuo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 */
@Configuration
@EnableDubboConfig
public class DubboConfig {
    @Autowired
    DemoService demoService;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("demoProvider2");
        return config;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        protocolConfig.setPort(8099);
        protocolConfig.setServer("tomcat");
        return protocolConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress("nacos://localhost:8848");
        registryConfig.setAddress("redis://localhost:6379");
        return registryConfig;
    }

    @Bean
    public ServiceConfig<DemoService> serviceConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig) {
        ServiceConfig<DemoService> service = new ServiceConfig<>();
        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(applicationConfig);
//        bootstrap.monitor(monitorConfig());
        bootstrap.registry(registryConfig);
        bootstrap.protocol(protocolConfig);
        service.setBootstrap(bootstrap);
        // 多个注册中心可以用setRegistries()
        service.setRef(demoService);
        // 多个协议可以用setProtocols()
        service.setInterface(DemoService.class);
        service.setVersion("1.0.0");

// 暴露及注册服务
        service.export();
        return service;
    }

    ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        return providerConfig;
    }

}

