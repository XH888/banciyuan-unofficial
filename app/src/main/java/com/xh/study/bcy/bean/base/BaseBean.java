package com.xh.study.bcy.bean.base;

/**
 * Created by xh on 21/05/2018.
 */

public class BaseBean<T> {
    /**
     * status : 1
     * message :
     * data : ??????
     **/

    private int status;
    private String message;
    private T data;


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
