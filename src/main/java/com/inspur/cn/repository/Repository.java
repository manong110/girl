package com.inspur.cn.repository;

import com.inspur.cn.repo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Girl,Integer> {

    /**
     * 根据年龄获取女生列表
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
