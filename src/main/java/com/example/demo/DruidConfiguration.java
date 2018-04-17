package com.example.demo;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean statViewServlet(){
        /*创建servlet注册实体*/
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        /*设置IP白名单*/
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        /*设置IP黑名单*/
        servletRegistrationBean.addInitParameter("deny", "192.168.0.19");
        /*设置控制台管理用户*/
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        /*是否可以重置数据*/
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return  servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        /*创建过滤器*/
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        /*设置过滤路径*/
        filterRegistrationBean.addUrlPatterns("/*");
        /*设置忽略过滤的形式*/
        filterRegistrationBean.addInitParameter("exclusions","/druid/*");
        return  filterRegistrationBean;

    }
}
