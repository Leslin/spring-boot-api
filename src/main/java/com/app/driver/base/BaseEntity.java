package com.app.driver.base;

import java.io.Serializable;

/**
 * Desc:查一些基本参数，分页、排序等
 * Author: dalin
 * Data: 2018/5/10
 * Time: 14:20
 */
public class BaseEntity implements Serializable {
    /**
     * <p>
     * 分页页码,默认页码为1
     * <p>
     */
    protected int page = 1;

    /**
     * <p>
     * 分页每页数量,默认20条
     * <p>
     */
    protected int size = 10;

    /**
     * <p>
     * 排序列名称,默认为id
     * <p>
     */
    protected String sidx = "id";

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    /**
     * 设置页码
     * @param page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * 获取每页数据
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置每页条数
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 获取排序
     * @return
     */
    public String getSidx() {
        return sidx;
    }

    /**
     * 设置排序
     * @param sidx
     */
    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    /**
     * 获取排序方式
     * @return
     */
    public String getSord() {
        return sord;
    }

    /**
     * 设置排序方式，正序或倒序
     * @param sord
     */
    public void setSord(String sord) {
        this.sord = sord;
    }
}
