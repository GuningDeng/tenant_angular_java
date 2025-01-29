package com.deng.tenantapi.domain;

public class JsonResult<T> {
    private T data;
    private String code;
    private String msg;
    
    /**
     * no data return
     * default code and msg
     */
    public JsonResult() {
        this.code = "0";
        this.msg = "No data return";
    }

    /**
     * no data return, custom code and msg
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * return data, status code 0, default msg
     * @param data
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "Operate successfully";
    }

    /**
     * return data, status code 0, custom msg
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.code = "0";
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
