package com.inspur.cn.repository;

import com.inspur.cn.repo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer age);
}
