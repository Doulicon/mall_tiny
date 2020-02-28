package com.macro.mall.tiny.config;

import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;


/**
 * mybatis配置类
 */
@Configuration
@MapperScan("com.macro.mall.tiny.mbg.mapper")
public class MybatisConfig {



}
