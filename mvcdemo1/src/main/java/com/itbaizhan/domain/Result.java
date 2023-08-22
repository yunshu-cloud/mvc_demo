package com.itbaizhan.domain;

// 请求的结果对象
public class Result {
    private boolean flag; // 请求是否成功
    private String message; // 请求提示信息
    // 省略getter/setter/构造方法


    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Result(boolean flag, String message)
    {
        this.flag = flag;
        this.message = message;
    }
}
