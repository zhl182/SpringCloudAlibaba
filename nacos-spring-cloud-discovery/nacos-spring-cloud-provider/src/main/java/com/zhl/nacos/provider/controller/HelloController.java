package com.zhl.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/sayHello/{str}")
    public String sayHello(@PathVariable String str){
        return "Nacos Provider SayHello to "+str;
    }

    @RequestMapping("/sayHelloUseConsumer/{str}")
    public String sayHelloUseConsumer(@PathVariable String str){
        return  restTemplate.getForObject("http://service-consumer/consumer/consumerSayHello/"+str,String.class);
    }
}
