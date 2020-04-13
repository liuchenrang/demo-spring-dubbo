package org.people.xinghuo.order.controller;

import org.apache.dubbo.config.ReferenceConfig;
import org.people.xinghuo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    //    @Reference(version = "1.0.0", check = false, protocol = "rest")
//    DemoService demoService;

    @Autowired
    ReferenceConfig<DemoService> services;

    @ResponseBody
    @RequestMapping("/order/get")
    public Object get() {
        return services.get().sayName("hao");
//        return demoService.sayName("hao");
    }
}
