package com.example.demo.entity;


import com.example.demo.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="t_user")
public class User extends BaseEntity implements UserDetails{
    @Id
    @GeneratedValue
    @Column(name="t_id")
	private Integer id;
    @Column(name="t_name")
    private String name;
    @Column(name="t_age")
    private Integer age;
    @Column(name="t_address")
    private String address;
    @Column(name="t_pwd")
    private String pwd;
    @ManyToMany
    @JoinTable(name = "t_user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public User() {
    }
    public User(String name, Integer age, String address, String pwd) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>result = new ArrayList<>();
        getRoleList().forEach(role -> result.add(new SimpleGrantedAuthority(role.getName())));
        return result;
    }

    @Override
    public String getPassword() {
        return getPwd();
    }

    @Override
    public String getUsername() {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}