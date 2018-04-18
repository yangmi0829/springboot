package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Administrator on 2017/11/9 0009.
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return  "hello spring security!!!";
    }
}
