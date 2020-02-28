package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.PmsBrandMapper;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author temp
 * @description  测试用的service
 * @date 2020/2/25
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> testFirst() {
        return  brandMapper.selectByExample(null);
    }
}
