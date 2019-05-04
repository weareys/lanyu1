package com.ys.lanyu1.support;

import java.io.Serializable;

public class SimpleResult  implements Serializable {

    private  Integer  code;
    private  Object  data;
    private  String  msg;

    public SimpleResult(int code, Object date, String msg) {
        this.code = code;
        this.data = date;
        this.msg = msg;
    }

    public static  SimpleResult  buildSuccess(String msg){
        SimpleResult result=new SimpleResult(0 , null ,msg);
        return  result;
    }

    public static  SimpleResult  buildSuccess(Object data,String msg){
        SimpleResult result=new SimpleResult(0 , data ,msg);
        return  result;
    }

    public static  SimpleResult  buildError(String msg){
        SimpleResult result=new SimpleResult(-1 , null ,msg);
        return  result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "SimpleResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
