package com.app.driver.controller;

import com.app.driver.util.RequestResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Desc:控制器基础抽象
 * Author: dalin
 * Data: 2018/5/19
 * Time: 16:04
 */
public abstract class BaseController {
    /* *
     * @Description获得来的request中的 key value数据封装到map返回
     * @Param [request]
     * @Return java.util.Map<java.lang.String,java.lang.String>
     */
    @SuppressWarnings("rawtypes")
    protected Map<String, String> getRequestParameter(HttpServletRequest request) {

        return RequestResponseUtil.getRequestParameters(request);
    }

    protected Map<String, String > getRequestHeader(HttpServletRequest request) {
        return RequestResponseUtil.getRequestHeaders(request);
    }
}
