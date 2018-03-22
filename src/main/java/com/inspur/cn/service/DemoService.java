package com.inspur.cn.service;

import com.inspur.cn.mapper.DemoMapper;
import com.inspur.cn.repo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public Demo getById(Integer id){
        return demoMapper.getById(id);
    }

    public String getNameById(Integer id){
        return demoMapper.getNameById(id);
    }

    public List<Demo> findName(String name){
       return demoMapper.findName(name);
    }

    public Demo save(Demo demo){
        return demoMapper.save(demo);
    }
}
