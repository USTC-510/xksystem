package com.system.pojo;

public class Result
{
    private int code;    //狀態碼
    private String msg;  //錯誤信息
    private Object data; //要傳給前端的數據

    public Result(){

    }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result success(){
        return new Result(1,null,null);
    }

    public static Result success(Object data){
        return new Result(1,null,data);
    }

    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
