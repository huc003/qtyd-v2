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
public class RedisDefaultUtils extends RedisUtils{

    @Resource(name = "DefaultRedisTemplate")
    private RedisTemplate defaultRedisTemplate;

    @Override
    RedisTemplate getRedisTemplate() {
        return defaultRedisTemplate;
    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/28 18:26
     * @Description: redis发布消息
    **/
    public void publishMessage(String topic,String str){
        defaultRedisTemplate.convertAndSend(topic,str);
    }
}
