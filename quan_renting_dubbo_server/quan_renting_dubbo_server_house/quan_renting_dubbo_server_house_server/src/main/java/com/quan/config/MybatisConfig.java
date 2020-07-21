package com.quan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.quan.mapper")
@Configuration
public class MybatisConfig {
}
