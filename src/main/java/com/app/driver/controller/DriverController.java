package com.app.driver.controller;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.*;

/**
 * Desc:司机端相关操作APP相关
 * Author: dalin
 * Data: 2018/5/21
 * Time: 17:00
 */
@RequestMapping("/driver")
@RestController
public class DriverController {

    /**
     * 根据司机id获取司机信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult getUserInfo(@PathVariable("id") Integer id
    ){
        return new JsonResult(ResultCode.SUCCESS,"success",id);
    }

    /**
     * 更新司机信息，密码、状态等
     * @param
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public JsonResult updateUserInfo(){
        return new JsonResult(ResultCode.SUCCESS,"success","1212");
    }

    /**
     * 上传司机的当前地理位置
     * @return
     */
    @RequestMapping(value = "/position",method = RequestMethod.POST)
    public JsonResult updatePosition(){
        return new JsonResult(ResultCode.SUCCESS,"success","1212");
    }


    /**
     * 司机故障上报
     * @return
     */
    @RequestMapping(value = "/trouble",method = RequestMethod.POST)
    public JsonResult updateTrouble(){
        return new JsonResult(ResultCode.SUCCESS,"success","1212");
    }

}
