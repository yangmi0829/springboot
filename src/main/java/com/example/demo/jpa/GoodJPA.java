package com.example.demo.jpa;

import com.example.demo.entity.GoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ym on 2018/4/16 0016.
 */
public interface GoodJPA extends JpaRepository<GoodInfo,Long>,QueryDslPredicateExecutor<GoodInfo> {
}
