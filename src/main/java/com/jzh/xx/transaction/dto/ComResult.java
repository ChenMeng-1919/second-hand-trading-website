package com.jzh.xx.transaction.dto;

import java.io.Serializable;

public class ComResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;

    public static ComResult success(){
        return creatComResult(STATUS_SUCCESS,"成功");
    }
    public static ComResult success(String message){
        return creatComResult(STATUS_SUCCESS,message);
    }

    public static ComResult fail(){
        return creatComResult(STATUS_FAIL,"失败");
    }
    public static ComResult fail(String message){
        return creatComResult(STATUS_FAIL,message);
    }
    public static ComResult fail(int status,String message){
        return creatComResult(status,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ComResult creatComResult(int status,String message){
        ComResult comResult = new ComResult();
        comResult.setStatus(status);
        comResult.setMessage(message);
        return comResult;
    }
}
