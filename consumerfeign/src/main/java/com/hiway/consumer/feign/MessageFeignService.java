package com.hiway.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "producer")
public interface MessageFeignService {

    @GetMapping("/get")
    String test(@RequestParam(value = "name") String name);
}
