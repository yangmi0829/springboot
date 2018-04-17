package com.example.demo.controller;

import com.example.demo.entity.GoodInfo;
import com.example.demo.entity.QGoodInfo;
import com.example.demo.jpa.GoodJPA;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by ym on 2018/4/16 0016.
 */
@RestController
@RequestMapping("/queryDSL")
public class QueryDSLController {
    @Autowired
    private GoodJPA goodJPA;
    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = "/list")
    public List list(){
        QGoodInfo goodInfo = QGoodInfo.goodInfo;
        JPAQuery<QGoodInfo> jpaQuery = new JPAQuery<>(entityManager);
        return jpaQuery
                .select(goodInfo)
                .from(goodInfo)
                .where(goodInfo.id.eq(Long.parseLong("1")))
                .fetch();
    }
}
