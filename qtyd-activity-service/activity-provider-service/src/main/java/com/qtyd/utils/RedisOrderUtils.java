package com.qtyd.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/28
 * @Description: 类描述
 **/
@Component
public class RedisOrderUtils extends RedisUtils{

    @Resource(name = "OrderRedisTemplate")
    private RedisTemplate orderRedisTemplate;

    @Override
    RedisTemplate getRedisTemplate() {
        return orderRedisTemplate;
    }
}
