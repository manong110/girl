package com.inspur.cn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @GetMapping(value = {"/hi","/hello"})
    public String say(){
        logger.info("springBoot快速入门");
        return "springBoot快速入门";
    }
}
