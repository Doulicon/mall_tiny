package com.macro.mall.tiny.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fengyongquan
 * @description
 * @date 2020/2/28
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    /**
     * @Api：用于修饰Controller类，生成Controller相关文档信息
     * @ApiOperation：用于修饰Controller类中的方法，生成接口方法相关文档信息
     * @ApiParam：用于修饰接口中的参数，生成接口参数相关文档信息
     * @ApiModelProperty：用于修饰实体类的属性，当实体类是请求参数或返回结果时，直接生成相关文档信息
     * @return
     */

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                //为当前包下controller生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.macro.mall.tiny.controller"))
            //为有@api注解的controller生成api文档
             //   .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
             //为有@ApiOperation注解的方法生成api文档
             //   .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI演示")
                .description("mall-tiny")
                .contact("macro")
                .version("1.0")
                .build();
    }

}
