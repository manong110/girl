package com.inspur.cn.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "girl")
@Getter
@Setter
public class GirlProperties {

    private int age;

    private String cupSize;
}
