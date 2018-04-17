package com.example.demo.entity;


import com.example.demo.base.BaseEntity;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name="good_infos")
public class GoodInfo extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name="tg_id")
	private Long id;
    @Column(name="tg_title")
    private String title;
    @Column(name="tg_price")
    private Double price;
    @Column(name="tg_unit")
    private String unit;
    @Column(name="tg_order")
    private Integer order;
    @OneToOne
    @JoinColumn(name="tg_type_id")
    @Valid
    private GoodType goodType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }
}