package com.app.driver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author: dalin
 * Data: 2018/5/19
 * Time: 16:05
 */
public class RequestResponseUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseUtil.class);

    /* *
     * @Description 取request中的已经被防止XSS，SQL注入过滤过的key value数据封装到map 返回
     * @Param [request]
     * @Return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String,String> getRequestParameters(ServletRequest request) {
        Map<String,String> dataMap = new HashMap<>();
        Enumeration enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = (String)enums.nextElement();
            String paraValue = RequestResponseUtil.getRequest(request).getParameter(paraName);
            if(null!=paraValue && !"".equals(paraValue)) {
                dataMap.put(paraName,paraValue);
            }
        }
        return dataMap;
    }

    /* *
     * @Description 读取request 已经被防止XSS，SQL注入过滤过的 请求参数key 对应的value
     * @Param [request, key]
     * @Return java.lang.String
     */
    public static String getParameter(ServletRequest request, String key) {
        return RequestResponseUtil.getRequest(request).getParameter(key);
    }

    /* *
     * @Description 读取request 已经被防止XSS，SQL注入过滤过的 请求头key 对应的value
     * @Param [request, key]
     * @Return java.lang.String
     */
    public static String getHeader(ServletRequest request, String key) {
        return RequestResponseUtil.getRequest(request).getHeader(key);
    }

    /* *
     * @Description 取request头中的已经被防止XSS，SQL注入过滤过的 key value数据封装到map 返回
     * @Param [request]
     * @Return java.util.Map<java.lang.String,java.lang.String>
     */
    public static Map<String,String> getRequestHeaders(ServletRequest request) {
        Map<String,String> headerMap = new HashMap<>();
        Enumeration enums = RequestResponseUtil.getRequest(request).getHeaderNames();
        while (enums.hasMoreElements()) {
            String name = (String) enums.nextElement();
            String value = RequestResponseUtil.getRequest(request).getHeader(name);
            if (null != value && !"".equals(value)) {
                headerMap.put(name,value);
            }
        }
        return headerMap;
    }

    public static HttpServletRequest getRequest(ServletRequest request) {
        return new XssSqlHttpServletRequestWrapper((HttpServletRequest) request);
    }


}
