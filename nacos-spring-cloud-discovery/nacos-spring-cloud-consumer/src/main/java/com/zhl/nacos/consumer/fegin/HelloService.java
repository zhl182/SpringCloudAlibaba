package com.zhl.nacos.consumer.fegin;

import com.zhl.nacos.consumer.fegin.fallback.HelloServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient的value指定的服务器提供者的application.name
 * 接口每个方法就是调用服务提供者的对应方法
 */
@FeignClient(value="service-provider",fallback = HelloServiceFallBack.class)
public interface HelloService {
    @GetMapping(value="/hello/sayHello/{str}")
    String sayHello(@PathVariable String str);
}
