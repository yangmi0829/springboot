package com.example.demo;

import com.example.demo.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ym on 2018/3/30 0030.
 */
@Configuration
@ServletComponentScan
public class ServletConfiguration {

    /*@Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new TestServlet(),"/test");
    }*/
}
