package org.people.xinghuo.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.people.xinghuo.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController  {
    @Reference(version = "1.0.0",check = false)
    DemoService demoService;
    @ResponseBody
    @RequestMapping("/order/get")
    public Object get(){
        return demoService.sayName("hao");
    }
}
