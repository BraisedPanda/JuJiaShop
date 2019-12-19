package com.braisedpanda.mypractices.commons.model;

import lombok.Data;

/**
 * @program: my-practices
 * @description: 返回代码
 * @author: chenzhen
 * @create: 2019-12-16 10:06
 **/

public enum  ResultCode {
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败")
    ;


    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
