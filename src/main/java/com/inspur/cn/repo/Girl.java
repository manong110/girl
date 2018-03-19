package com.inspur.cn.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "罩杯不能为空")
    private String cupSize;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;
}
