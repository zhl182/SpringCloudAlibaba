package com.zhl.nacos.consumer.controller;

import com.zhl.nacos.consumer.fegin.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/sayHello/{str}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String str) {
        return restTemplate.getForObject("http://service-provider/hello/sayHello/" + str, String.class);
    }

    /**
     * 使用OpenFegin来进行服务调用
     * @param str
     * @return
     */
    @RequestMapping(value = "/sayHelloWithFegin/{str}", method = RequestMethod.GET)
    public String sayHelloWithFegin(@PathVariable String str) {
        return helloService.sayHello(str);
    }

    @RequestMapping(value="/consumerSayHello/{str}",method = RequestMethod.GET)
    public String consumerSayHello(@PathVariable String str){
        return "ConsumerSayHello "+str;
    }
}
