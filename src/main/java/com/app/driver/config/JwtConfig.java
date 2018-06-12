package com.app.driver.config;

import com.app.driver.jwt.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Desc:jwt路由拦截，配置对应目录进行token验证
 * Author: dalin
 * Data: 2018/5/18
 * Time: 16:32
 */
@Configuration
public class JwtConfig {

    @Bean
    public FilterRegistrationBean jwtFilter(){
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        /*==========需要验证的路由=================*/

        registrationBean.addUrlPatterns("/user/*");
        //registrationBean.addUrlPatterns("/driver/*");

        /*==========需要验证的路由=================*/
        return registrationBean;
    }
}
