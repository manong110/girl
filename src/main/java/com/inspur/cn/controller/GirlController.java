package com.inspur.cn.controller;

import com.inspur.cn.repo.Girl;
import com.inspur.cn.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private Repository repository;

    /**
     * 获取所有女生信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> findAll(){
        return repository.findAll();
    }

    /**
     * 添加女生
     * @param girl
     * @return
     */
    @PostMapping(value= "/girls")
    public Girl addGirl(Girl girl){
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return repository.save(girl);
    }

    /**
     * 更新女生信息
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl uppGirl(@PathVariable("id")Integer id,
                        @RequestParam("age")Integer age,
                        @RequestParam("cupSize")String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return repository.save(girl);
    }

    /**
     * 查询一个女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl getGirl(@PathVariable("id")Integer id){
        return repository.findOne(id);
    }

    /**
     * 删除一个女生信息
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void delGirl(@PathVariable("id")Integer id){
        repository.delete(id);
        return;
    }


}
