package com.app.driver.controller;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
public class OrderController {

    /**
     * restful相关接口卡，GET
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public JsonResult listOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }

    /**
     * POST
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public JsonResult updateOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }
}
