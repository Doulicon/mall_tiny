package com.macro.mall.tiny.test;

import com.macro.mall.tiny.MallTinyApplication;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fengyongquan
 * @description
 * @date 2020/3/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MallTinyApplication.class})
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

        UmsAdmin user = new UmsAdmin();
        user.setUsername("fyq");
        user.setPassword("123");

        redisTemplate.opsForValue().set("user_1", user);
        UmsAdmin user1 = (UmsAdmin) redisTemplate.opsForValue().get("user_1");

        System.out.println(user1.getUsername());
    }
}
