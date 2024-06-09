package com.system.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result
{
    private int code;    //狀態碼
    private String msg;  //錯誤信息
    private Object data; //要傳給前端的數據

    public static Result success(Object data){
        return new Result(1,null,data);
    }

    public static Result error(String msg,Object data) {return new Result(0,msg,data);}
}
