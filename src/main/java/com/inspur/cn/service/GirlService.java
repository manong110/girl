package com.inspur.cn.service;

import com.inspur.cn.common.exception.GirlException;
import com.inspur.cn.common.exception.ResultEnum;
import com.inspur.cn.repo.Girl;
import com.inspur.cn.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GirlService {

    @Autowired
    private Repository repository;

    public Girl getGirl(Integer id){
        Girl girl = repository.findOne(id);
        return  girl;
    }


    public void getGirlAge(Integer id) throws Exception{
        Girl girl = repository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.XYERROR);
        }else if(age >10 && age<16){
            throw new GirlException(ResultEnum.CZERROR);
        }
    }
}
