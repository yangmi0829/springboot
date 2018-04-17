package com.example.demo;


import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ym on 2018/4/16 0016.
 */
public class Inquirer {
    private List<BooleanExpression> expressionList;

    public Inquirer() {
        this.expressionList = new ArrayList<>();
    }

    public Inquirer addExpression(BooleanExpression expression){
        expressionList.add(expression);
        return this;
    }

    /**
     * 拼接查询条件
     * @return
     */
    public Predicate buildQuery(){
        BooleanExpression be= null;
        for(int i = 0 ; i < expressionList.size() ; i++){
            if( i == 0 ){
                be = expressionList.get(i);
            }else {
                be = be.and(expressionList.get(i));
            }
        }
        return be;
    }

    /**
     * 迭代器=>list
     * @param iterator
     * @param <T>
     * @return
     */
    public <T> List<T> iteratorToList(Iterator<T> iterator){
        List<T> result = new ArrayList<>();
        while(iterator.hasNext()){
            result.add(iterator.next());
        }
        return result;
    }

}
