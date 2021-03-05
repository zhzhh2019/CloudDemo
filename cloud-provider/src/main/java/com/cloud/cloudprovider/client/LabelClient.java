package com.cloud.cloudprovider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("nacos-service")
@Component
public interface LabelClient {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
     String findAll();
}
