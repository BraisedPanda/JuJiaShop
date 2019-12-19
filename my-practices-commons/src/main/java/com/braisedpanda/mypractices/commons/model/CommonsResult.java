package com.braisedpanda.mypractices.commons.model;

import lombok.Data;

/**
 * @program: my-practices
 * @description: 同一返回类型
 * @author: chenzhen
 * @create: 2019-12-16 10:02
 **/
@Data
public class CommonsResult<T> {
    private String message;
    private Integer code;
    private T data;

    public CommonsResult(Integer code, String message,  T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public CommonsResult(Integer code, String message) {
        this.message = message;
        this.code = code;

    }

    /**
    * @Description: 返回成功
    * @author: chenzhen
    * @Date: 2019/12/16 0016
    */
    public static <T> CommonsResult<T> success (T data){
        return new CommonsResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonsResult<T> success (T data, String message){
        return new CommonsResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
    public static <T> CommonsResult<T> success (String message){
        return new CommonsResult<T>(ResultCode.SUCCESS.getCode(), message);
    }
    public static <T> CommonsResult<T> success (){
        return new CommonsResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }
    
    
    /** 
    * @Description: 返回失败
    * @author: chenzhen
    * @Date: 2019/12/16 0016 
    */

    public static <T> CommonsResult<T> failed (T data){
        return new CommonsResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), data);
    }

    public static <T> CommonsResult<T> failed (T data, String message){
        return new CommonsResult<T>(ResultCode.FAILED.getCode(), message, data);
    }
    public static <T> CommonsResult<T> failed ( String message){
        return new CommonsResult<T>(ResultCode.FAILED.getCode(), message);
    }
    public static <T> CommonsResult<T> failed (){
        return new CommonsResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

}
