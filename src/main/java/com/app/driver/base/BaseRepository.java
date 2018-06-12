package com.app.driver.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Desc:
 * Author: dalin
 * Data: 2018/5/10
 * Time: 14:16
 * @NoRepositoryBean
 * Spring开源程序猿在命名规则上应该是比较严格的，从名字上我们几乎就可以判断出用途，这个注解如果配置在继承了JpaRepository接口以及其他SpringDataJpa内部的接口的子接口时，子接口不被作为一个Repository创建代理实现类。
 */
@NoRepositoryBean
public interface BaseRepository<T,PK extends Serializable> extends JpaRepository<T,PK>{
}
