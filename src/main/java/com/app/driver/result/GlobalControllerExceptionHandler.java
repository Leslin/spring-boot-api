package com.app.driver.result;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;

/**
 * Desc:全局异常处理，code status需相应正确的状态码
 * Author: dalin
 * Data: 2018/5/10
 * Time: 17:06
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult constraintViolationException(ConstraintViolationException ex) {
        return new JsonResult(ResultCode.PARAMS_ERROR, "BAD_REQUEST", ex.getMessage());
    }

    @ExceptionHandler(value = { IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResult IllegalArgumentException(IllegalArgumentException ex) {
        return new JsonResult(ResultCode.EXCEPTION, "BAD_REQUEST", ex.getMessage());
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonResult noHandlerFoundException(Exception ex) {
        return new JsonResult(ResultCode.NOT_FOUND, "NOT_FOUND", ex.getMessage());
    }


    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult unknownException(Exception ex) {
        return new JsonResult(ResultCode.SYS_ERROR, "INTERNAL_SERVER_ERROR", ex.getMessage());
    }
}