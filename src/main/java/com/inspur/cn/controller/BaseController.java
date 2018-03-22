package com.inspur.cn.controller;

import com.inspur.cn.properties.GirlProperties;
import com.inspur.cn.repo.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BaseController {

    @Value("${age}")
    private Integer age;
    @Value("${cupSize}")
    private String cupSize;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @GetMapping(value = {"/hi","/hello"})
    public String say(){
        logger.info("springBoot快速入门");
        return "springBoot快速入门";
    }

    @GetMapping(value = "/info")
    public String getInfo(){
        return age + cupSize;
    }

    @GetMapping(value="/content")
    public String getContent(){
        return content;
    }

    @GetMapping(value="/getInfo")
    public String getCupSize(){
        return girlProperties.getCupSize()+girlProperties.getAge();
    }

    @GetMapping(value="/demo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setCreatTime(new Date());
        return demo;
    }
}
