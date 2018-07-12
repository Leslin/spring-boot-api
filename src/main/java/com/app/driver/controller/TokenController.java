package com.app.driver.controller;

import com.app.driver.entity.DriverOauthEntity;
import com.app.driver.jpa.DriverOauthJPA;
import com.app.driver.jwt.CreateJwtToken;
import com.app.driver.logic.TokenLogic;
import com.app.driver.result.JsonResult;
import com.app.driver.result.ResultCode;
import com.app.driver.service.IRedisService;
import com.app.driver.util.CommonUtil;
import com.app.driver.util.RequestResponseUtil;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 框架通用的restful api接口生成token
 * Desc:
 * Author: dalin
 * Data: 2018/5/19
 * Time: 12:25
 */
@RestController
@RequestMapping("token")
public class TokenController extends BaseController{

    @Autowired
    IRedisService redisService;   //redis相关服务

    @Autowired
    DriverOauthJPA driverOauthJPA;

    /**
     * APP端获取登录的密码加盐参数
     * redis缓存时间为5秒，获取key后，5秒钟还未调用登录接口，则不允许登录
     * @return
     */
    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
    public JsonResult getKey(){
        String userKey = CommonUtil.getRandomString(5);
        String userValue = CommonUtil.getRandomString(12);
        try {
            Boolean setUserKey = redisService.set(userKey,userValue);
            Boolean setExprie = redisService.expire(userKey,5);
            Map<String,String> list = new HashMap<>();
            list.put("userkey",userKey);
            list.put("uservalue",userValue);
            list.put("exprie","5");
            return new JsonResult(ResultCode.SUCCESS,"success",list);
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR,"获取用户key失败",e);
        }
    }

    /**
     * app端登录接口
     */
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public JsonResult getToken(HttpServletRequest request){

        Map<String, String> params = RequestResponseUtil.getRequestParameters(request);
        String appid = params.get("appid");  //appid
        String timestamp = params.get("timestamp");//时间戳
        String nonce  = params.get("nonce");      //随机数
        String sign   = params.get("sign");       //签名
        String mobile = params.get("mobile");     //手机号
        String password = params.get("password"); //密码
        String userkey = params.get("userkey");

        if(StringUtils.isEmpty(appid)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"appid不能为空",null);
        }
        if(StringUtils.isEmpty(timestamp)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"timestamp不能为空",null);
        }
        if(StringUtils.isEmpty(nonce)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"nonce不能为空",null);
        }
        if(StringUtils.isEmpty(sign)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"sign不能为空",null);
        }
        if(StringUtils.isEmpty(mobile)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"mobile不能为空",null);
        }
        if(StringUtils.isEmpty(password)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"password不能为空",null);
        }
        if(StringUtils.isEmpty(userkey)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"userkey不能为空，请申请userkey",null);
        }

        List<DriverOauthEntity> list = driverOauthJPA.findByAppid(appid);
        String appsercet = list.get(0).getAppid();  //取appsercet
        String uservalue = redisService.get(userkey);//userkey

        //redis 根据key取出来为空，不允许登录，表明登录接口已经超时，超过5秒
        if (userkey == null || userkey == ""){
            return new JsonResult(ResultCode.EXCEPTION,"uservalue is null");
        }
        //检测登录密码是否正确
        Boolean checkPassword = TokenLogic.checkPassword(password,"123456",uservalue);
        if(!checkPassword){
            return new JsonResult(ResultCode.EXCEPTION,"password error");
        }
        //判断签名是否正确
        Boolean checkSign = TokenLogic.checkSign(params,appsercet);
        if(!checkSign){
            return new JsonResult(ResultCode.EXCEPTION,"sign error");
        }
        //生成token凭证
        try {
            String jwtToken = CreateJwtToken.createJwtToken(mobile,"driver");
            return new JsonResult(ResultCode.SUCCESS,"success",jwtToken);
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR,"success","生成token错误,"+e);
        }
    }


    /**
     * 第三方接口获取token，区别于APP登录，这里是只第三方推送数据使用token
     */
    @RequestMapping(value = "/getTokenByThird", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public JsonResult getTokenByThird(@RequestBody Map<String,String> params){

        String appid = params.get("appid");        //appid
        String timestamp = params.get("timestamp");//时间戳
        String nonce  = params.get("nonce");      //随机数
        String sign   = params.get("sign");       //签名
        if(StringUtils.isEmpty(appid)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"appid不能为空",null);
        }
        if(StringUtils.isEmpty(timestamp)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"timestamp不能为空",null);
        }
        if(StringUtils.isEmpty(nonce)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"nonce不能为空",null);
        }
        if(StringUtils.isEmpty(sign)){
            return new JsonResult(ResultCode.PARAMS_ERROR,"sign不能为空",null);
        }

        List<DriverOauthEntity> list = driverOauthJPA.findByAppid(appid);

        String appsercet = list.get(0).getAppid();  //取appsercet
        Boolean checkSign = TokenLogic.checkSign(params,appsercet);
        if(!checkSign){
            return new JsonResult(ResultCode.EXCEPTION,"sign error");
        }
        //生成token凭证
        try {
            String jwtToken = CreateJwtToken.createJwtToken(appid,"third");
            return new JsonResult(ResultCode.SUCCESS,"success",jwtToken);
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR,"success","生成第三方token错误,"+e);
        }
    }
}
