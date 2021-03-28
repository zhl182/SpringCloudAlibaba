package com.zhl.nacos.consumer.fegin.fallback;

import com.zhl.nacos.consumer.fegin.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallBack implements HelloService {
    @Override
    public String sayHello(String str) {
        System.out.println("服务调用失败,进行降级处理!");
        return "error";
    }
}
