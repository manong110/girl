package com.inspur.cn.common.util;

import com.inspur.cn.repo.Result;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return null;
    }

    public static Result error(String msg){
        Result result = new Result();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
