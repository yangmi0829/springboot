package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        User result = userJPA.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        if(result == null){
            return  "account does not exist!";
        }else{
            if (result.getPwd().equals(user.getPwd())){
                request.getSession().setAttribute("user",result);
                return  "login success";
            }else {
                return  "error password";
            }
        }
    }

}
