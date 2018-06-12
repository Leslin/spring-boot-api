package com.app.driver.controller;

import com.app.driver.jwt.CreateJwtToken;
import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author: dalin
 * Data: 2018/5/18
 * Time: 15:08
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public JsonResult index() throws Exception{
        String jwtToken = CreateJwtToken.createJwtToken("15826571243","test");
        Map<String,String> list = new HashMap<>();
        list.put("token",jwtToken);
        list.put("expire",new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000 * 10).toString());

        ThreadController t1 = new ThreadController("Thread1");
        t1.start();
        ThreadController t2 = new ThreadController("Thread2");
        t2.start();
        return new JsonResult(ResultCode.SUCCESS,"success",list);
    }
}
