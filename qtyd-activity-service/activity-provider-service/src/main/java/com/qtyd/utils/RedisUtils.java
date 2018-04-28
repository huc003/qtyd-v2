package com.qtyd.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 胡成
 * @Date:   2018/4/18 15:01
 * @Description: redis工具类
**/
@Component
public abstract class RedisUtils {

    abstract RedisTemplate getRedisTemplate();

    public Long lpush(String key,String value){
        return getRedisTemplate().opsForList().leftPush(key, value);
    }

    public Object pop(String key){
        return getRedisTemplate().opsForList().leftPop(key);
    }

    public Long rpush(String key,String value){
        return getRedisTemplate().opsForList().rightPush(key, value);
    }

    public Object out(String key){
        return getRedisTemplate().opsForList().rightPop(key);
    }

    public Long length(String key){
        return getRedisTemplate().opsForList().size(key);
    }

    public List<String> range(String key, int start, int end){
        return getRedisTemplate().opsForList().range(key, start, end);
    }

    public void remove(String key,int count,String value){
        getRedisTemplate().opsForList().remove(key, count, value);
    }

    public Object index(String key,long index){
        return getRedisTemplate().opsForList().index(key, index);
    }

    public void set(String key,long index,String value){
        getRedisTemplate().opsForList().set(key, index, value);
    }

    public void trim(String key,long start,long end){
        getRedisTemplate().opsForList().trim(key, start, end);
    }

    public void clean(String key){
        getRedisTemplate().delete(key);
    }
}
