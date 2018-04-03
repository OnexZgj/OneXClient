package com.it.onex.onex.bean;

/**
 * Created by Linsa on 2018/4/3:10:00.
 * des:返回数据的基础bean
 */

public class DataResponse<T> {

    /**
     * data : ...
     * errorCode : 0
     * errorMsg :
     */

    private T data;
    private int errorCode;
    private String errorMsg;


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
