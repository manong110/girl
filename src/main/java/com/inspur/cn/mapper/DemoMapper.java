package com.inspur.cn.mapper;

import com.inspur.cn.repo.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoMapper {

    @Select("select * from Demo Where id=#{id}")
    public Demo getById(Integer id);

    @Select("select name from Demo Where id=#{id}")
    public String getNameById(Integer id);

    @Select("select * from Demo Where name=#{name}")
    public List<Demo> findName(String name);

    @Insert("insert into Demo(name) values(#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id",keyProperty = "id")
    public Demo save(Demo demo);
}
