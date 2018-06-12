package com.app.driver.controller;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:订单相关接口
 * Author: dalin
 * Data: 2018/5/21
 * Time: 17:36
 */
@RequestMapping("/order")
@RestController
public class OrderController {

    /**
     * 根据运单id获取对应的订单列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public JsonResult listOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }

    /**
     * 更新订单的路由状态
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public JsonResult updateOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }

    /**
     * 已经支付订单订单签收
     * @return
     */
    @RequestMapping(value = "/receive",method = RequestMethod.POST)
    public JsonResult receiveOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }

    /**
     * 货到付款类订单支付签收
     * @return
     */
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public JsonResult payOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }

    /**
     * 订单签收上传电子回单
     * @return
     */
    @RequestMapping(value = "/voucher",method = RequestMethod.POST)
    public JsonResult voucherOrder(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }
}
