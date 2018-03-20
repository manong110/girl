package com.inspur.cn.controller;

import com.inspur.cn.repo.Girl;
import com.inspur.cn.repository.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)

public class GirlControllerTest {

    @Autowired
    private Repository repository;

    @Test
    public void findGirl(){
        Girl girl = repository.findOne(4);
        Assert.assertEquals(new Integer(13),girl.getAge());
    }
}