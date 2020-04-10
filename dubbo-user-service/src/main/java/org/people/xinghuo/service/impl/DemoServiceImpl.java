package org.people.xinghuo.service.impl;

import org.people.xinghuo.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(version = "${demo.service.version}")
@Component
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayName(String name) {
        return "duoduohppp1dd" + "1";
    }
}
