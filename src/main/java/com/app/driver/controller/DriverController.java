package com.app.driver.controller;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/driver")
@RestController
public class DriverController {

    /**
     * 获取某个信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public JsonResult getUserInfo(@PathVariable("id") Integer id
    ){
        return new JsonResult(ResultCode.SUCCESS,"success",id);
    }

}
