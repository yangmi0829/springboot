package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ym on 2018/4/17 0017.
 */
public class UserService implements UserDetailsService{
    @Autowired
    private UserJPA userJPA;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        User user = userJPA.findByName(name);
        if(user == null){
            throw new UsernameNotFoundException("用户"+name+"不存在");
        }
        return user;
    }
}
