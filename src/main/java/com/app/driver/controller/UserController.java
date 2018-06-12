package com.app.driver.controller;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:test
 * Author: dalin
 * Data: 2018/5/18
 * Time: 16:36
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public JsonResult getUserInfo(){
        return new JsonResult(ResultCode.SUCCESS,"succsess","okok");
    }
}
