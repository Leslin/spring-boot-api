package com.app.driver.service;

import java.util.List;

/**
 * Desc:redis接口
 * Author: dalin
 * Data: 2018/5/11
 * Time: 13:04
 */
public interface IRedisService {

    public boolean set(String key, String value);

    public String get(String key);

    public boolean expire(String key,long expire);

    public <T> boolean setList(String key ,List<T> list);

    public <T> List<T> getList(String key,Class<T> clz);

    public long lpush(String key,Object obj);

    public long rpush(String key,Object obj);

    public String lpop(String key);
}
