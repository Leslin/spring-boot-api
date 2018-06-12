package com.app.driver.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Desc:oauth实体
 * Author: dalin
 * Data: 2018/5/18
 * Time: 18:26
 */
@Entity
@Table(name = "driver_oauth", schema = "logistics")
public class DriverOauthEntity {
    private int id;
    private String appid;
    private String appsecret;
    private Integer expire;
    private Byte isopen;
    private String remark;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "appid", nullable = true, length = 32)
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "appsecret", nullable = true, length = 128)
    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    @Basic
    @Column(name = "expire", nullable = true)
    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    @Basic
    @Column(name = "isopen", nullable = true)
    public Byte getIsopen() {
        return isopen;
    }

    public void setIsopen(Byte isopen) {
        this.isopen = isopen;
    }

    @Basic
    @Column(name = "remark", nullable = false, length = 32)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverOauthEntity that = (DriverOauthEntity) o;
        return id == that.id &&
                Objects.equals(appid, that.appid) &&
                Objects.equals(appsecret, that.appsecret) &&
                Objects.equals(expire, that.expire) &&
                Objects.equals(isopen, that.isopen) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, appid, appsecret, expire, isopen, remark);
    }
}
