package com.inspur.cn.controller;

import com.inspur.cn.common.util.ResultUtil;
import com.inspur.cn.repo.Demo;
import com.inspur.cn.repo.Result;
import com.inspur.cn.service.DemoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class DemoController {

    private DemoService demoService;

    @GetMapping("/demo/{id}")
    public Result getById(@PathVariable Integer id){
        return ResultUtil.success(demoService.getById(id));
    }

    @GetMapping("/demo/{name}")
    public Result findName(@RequestParam String name){
        return ResultUtil.success(demoService.findName(name));
    }

    @GetMapping("/demo/name/{id}")
    public Result getNameById(@PathVariable Integer id){
        return ResultUtil.success(demoService.getNameById(id));
    }

    @PostMapping("/demo")
    public Result getDemoInfo(Demo demo){
        Demo d = new Demo();
        d.setName(demo.getName());
        d.setCreatTime(new Date());
        d.setUpdateTime(new Date());

        return ResultUtil.success(demoService.save(d));
    }

}
