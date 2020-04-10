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
@EnableDubboConfig
public class DubboConfig {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName("orderProvider2");
        return config;
    }
    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("redis://localhost:6379");
        return registryConfig;
    }
    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("http");
        protocolConfig.setPort(8099);
        return protocolConfig;
    }
    public MonitorConfig monitorConfig(){
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
    ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        return providerConfig;
    }
    @Bean
    public ReferenceConfig<DemoService> serviceConfig(){
        ReferenceConfig<DemoService> service = new ReferenceConfig<>();
        DubboBootstrap bootstrap = DubboBootstrap.getInstance().application(applicationConfig());
        bootstrap.monitor(monitorConfig());
        bootstrap.registry(registryConfig());
        bootstrap.protocol(protocolConfig());
        service.setBootstrap(bootstrap);
        // 多个注册中心可以用setRegistries()
        service.setInterface(DemoService.class);
        service.setVersion("1.0.0");

        return service;
    }

}

