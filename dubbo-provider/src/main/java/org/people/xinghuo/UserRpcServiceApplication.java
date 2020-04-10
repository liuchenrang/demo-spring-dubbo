package org.people.xinghuo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class UserRpcServiceApplication {

	public static void main(String[] args) {
		System.out.println("11");
		SpringApplication.run(UserRpcServiceApplication.class, args);
	}

}
