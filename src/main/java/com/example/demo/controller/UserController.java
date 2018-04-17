package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    @RequestMapping("/list")
    public List<User> list() {
        return userJPA.findAll();
    }

    @RequestMapping("/save")
    public User save(User user) {
        return userJPA.save(user);
    }

    @RequestMapping("/del")
    public List<User> del(Long id) {
        userJPA.delete(id);
        return userJPA.findAll();
    }

    @GetMapping("/query")
    public User query(Long id){
        return  userJPA.findOne(id);
    }

    @RequestMapping("/findByName")
    public User findByName(String name){
        return  userJPA.findByName(name);
    }

    @RequestMapping("/queryByName")
    public User queryByName(String name){
        return  userJPA.queryByName(name);
    }

    @RequestMapping("/modifyById/{id}")
    public Integer modifyById(@PathVariable Long id){
        return  userJPA.modifyById(id);
    }

    @RequestMapping("/page")
    public List<User> page(){
        PageRequest pageRequest = new PageRequest(0,2);
        return userJPA.findAll(pageRequest).getContent();
    }
}
