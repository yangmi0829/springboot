package com.example.demo.entity;

import com.example.demo.base.BaseEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by ym on 2018/4/17 0017.
 */
public class ValidatorEntity extends BaseEntity {
    @NotEmpty(message = "名字不能为空")
    private String name;
    @Min(value = 0,message = "年龄不能小于0")
    @Max(value = 150,message = "年龄不能大于150")
    private Integer age;
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
