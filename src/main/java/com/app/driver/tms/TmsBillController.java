package com.app.driver.tms;

import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Desc:TMS相关接口，含推送数据以及调用API
 * Author: dalin
 * Data: 2018/5/23
 * Time: 17:30
 */
@RequestMapping("/tms")
@RestController
public class TmsBillController {

    /**
     * 接受TMS第三方推送运单数据
     * @return
     */
    @RequestMapping(value = "/bill/accept",method = RequestMethod.POST)
    public JsonResult acceptBill(){
        return new JsonResult(ResultCode.SUCCESS,"success",null);
    }


}
