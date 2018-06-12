package com.app.driver.result;

/**
 * Desc:reastful 返回码定义
 * Author: dalin
 * Data: 2018/5/10
 * Time: 17:05
 */
public enum ResultCode {

    /** 成功 */
    SUCCESS("200", "成功"),

    /** 没有登录 */
    NOT_LOGIN("400", "没有登录，token验证失败"),

    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("500", "系统错误，请联系管理员"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误，禁止访问"),

    /** 资源不存在 */
    NOT_FOUND("404", "不存在的路由"),

    /** 不支持或已经废弃 */
    NOT_SUPPORTED("410", "不支持或已经废弃"),

    /** AuthCode错误 */
    INVALID_AUTHCODE("444", "无效的AuthCode"),

    /** 太频繁的调用 */
    TOO_FREQUENT("445", "太频繁的调用"),

    /** 未知的错误 */
    UNKNOWN_ERROR("499", "未知错误");



    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

}
