package com.werner.common.util;

import lombok.Data;

import java.io.Serializable;


@Data
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = 5310577023711488691L;
    //返回状态 0异常 1成功
    private Integer code;
    //返回状态描述
    private String message;
    //返回数据
    private T data;

    public ResponseData(Integer code,String message ,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }


    public static<T> ResponseData successful(T data){
       return new ResponseData(1,"成功",data);
    }

    public static<T> ResponseData fail(T data){
        return new ResponseData(0,"失败",data);
    }

}
