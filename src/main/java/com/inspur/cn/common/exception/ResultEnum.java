package com.inspur.cn.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(0,"成功"),
    ERROR(-1,"系统错误"),
    XYERROR(100,"你有可能在上小学"),
    CZERROR(101,"你有可能在上初中")
    ;
    private Integer code;

    private String msg;
}
