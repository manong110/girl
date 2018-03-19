package com.inspur.cn.repo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Result<T> {

    private Integer code;

    private String msg;

    private Object data;

}
