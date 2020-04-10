package org.people.xinghuo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class UserRpcServiceApplication {

	public static void main(String[] args) {
		System.out.println("11");
		SpringApplication.run(UserRpcServiceApplication.class, args);
	}

}
