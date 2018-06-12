package com.app.driver.jpa;

import com.app.driver.entity.DriverOauthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Desc:
 * Author: dalin
 * Data: 2018/5/21
 * Time: 11:48
 */
@Transactional
public interface DriverOauthJPA extends JpaRepository<DriverOauthEntity,Integer>,JpaSpecificationExecutor<DriverOauthEntity>{
    List<DriverOauthEntity> findByAppid(String appid);
}
