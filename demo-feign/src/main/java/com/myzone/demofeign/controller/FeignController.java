package com.myzone.demofeign.controller;

import com.myzone.demofeign.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testFeign() {

        //feign调用时获取上下文需要配置config
        return feignService.sayHello();
    }
}
