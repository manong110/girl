package com.inspur.cn.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Result<T> {

    private Integer code;

    private String msg;

    private Object data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
