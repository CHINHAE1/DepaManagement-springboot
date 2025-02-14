package org.example.depamanagement.exception;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/5 16:59
 * @version: 1.0
 */

import org.example.depamanagement.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("对不起,操作失败,请联系管理员");
    }

}