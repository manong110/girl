package com.inspur.cn.common.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
