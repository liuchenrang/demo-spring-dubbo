package org.people.xinghuo.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.people.xinghuo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(version = "${demo.service.version}")
@Component
public class DemoServiceImpl implements DemoService {
    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @Override
    public String sayName(String name) {
        if (useLocalCache){
            return "true";
        }else{
            return "false";
        }
    }
}
