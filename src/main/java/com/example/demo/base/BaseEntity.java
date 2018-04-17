package com.example.demo.base;

import java.io.Serializable;

/**
 * Created by ym on 2018/4/16 0016.
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -2864868212175269611L;
    protected int page = 1;
    protected int size = 2;
    protected String sidx = "id";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }
}
