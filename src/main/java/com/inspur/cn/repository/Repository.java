package com.inspur.cn.repository;

import com.inspur.cn.repo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Girl,Integer> {
}
