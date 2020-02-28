package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.service.TestService;
import io.micrometer.core.instrument.Tags;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description   测试的controller
 * @author   temp
 * @date   2020/2/25
 */

@Api(tags = "TestController" ,description = "接口测试")
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @ApiOperation("测试接口（查询所有品牌json格式输出）")
    @RequestMapping(value = "first" , method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> firstTest(){
        return CommonResult.success(testService.testFirst());
    }



}
