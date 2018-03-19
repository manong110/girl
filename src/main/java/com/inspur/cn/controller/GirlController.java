package com.inspur.cn.controller;

import com.inspur.cn.common.util.ResultUtil;
import com.inspur.cn.repo.Girl;
import com.inspur.cn.repo.Result;
import com.inspur.cn.repository.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

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
    public Result addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg =bindingResult.getFieldError().getDefaultMessage();
            logger.error("msg->{}",msg);
            return ResultUtil.error(msg);
        }
        girl.setCupSize(girl.getCupSize());
        girl.setId(girl.getId());
        girl.setAge(girl.getAge());
        return ResultUtil.success(repository.save(girl));
    }

    /**
     * 更新女生信息
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Result uppGirl(@PathVariable("id")Integer id,
                          @RequestParam("age")Integer age,
                          @RequestParam("cupSize")String cupSize,
                          BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            logger.error("msg->{}",msg);
            return ResultUtil.error(msg);
        }
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return ResultUtil.success(repository.save(girl));
    }

    /**
     * 查询一个女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Result getGirl(@PathVariable("id")Integer id){
        return ResultUtil.success(repository.findOne(id));
    }

    /**
     * 删除一个女生信息
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public Result delGirl(@PathVariable("id")Integer id){
        repository.delete(id);
        return ResultUtil.success();
    }


}
