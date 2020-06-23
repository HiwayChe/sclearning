package com.hiway.consumer.controller;

import com.hiway.consumer.feign.MessageFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MessageFeignService messageFeignService;

    @GetMapping("/get")
    public String showMessage(@RequestParam String name){
        return restTemplate.getForObject("http://producer/get?name="+name, String.class);
    }

    @GetMapping("/get2")
    public String showMessage2(@RequestParam String name){
        return this.messageFeignService.test(name);
    }
}
