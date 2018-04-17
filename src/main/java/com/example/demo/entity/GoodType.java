package com.example.demo.entity;


import com.example.demo.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="good_types")
public class GoodType extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="tgt_id")
	private Long id;
    @Column(name="tgt_name")
    private String name;
    @Column(name="tgt_is_show")
    private Integer show;
    @Column(name="tgt_order")
    private Integer order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}