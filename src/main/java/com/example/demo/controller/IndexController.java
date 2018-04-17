package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Administrator on 2017/11/9 0009.
 */
@Controller
public class IndexController {

    @RequestMapping("/page/{path}")
    public String page(@PathVariable String path){
        return  path;
    }
}
