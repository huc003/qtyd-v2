package com.qtyd.api;

import com.alibaba.fastjson.JSONObject;
import com.qtyd.service.UserService;
import com.qtyd.utils.RedisDefaultUtils;
import com.qtyd.utils.RedisOrderUtils;
import com.qtyd.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:10
 * @Description: 服务提供者具体的实现
**/
@Slf4j
@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private RedisDefaultUtils redisUtils;
    @Autowired
    private RedisOrderUtils redisOrderUtils;

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserService userService;

    @GetMapping("add/{id}")
    public String addRedis(@PathVariable("id") String id){
        //获取当天日期
        redisUtils.lpush("success_order_"+TimeUtils.strDay(),"{user_id:"+id+",order_id:123123123,add_time:1523859194}");
//        redisOrderUtils.lpush("success_order_"+TimeUtils.strDay(),"{user_id:"+id+",order_id:123123123,add_time:1523859194}");
//        System.out.println("从redis取出数据:"+redisUtils.pop("success_order_"+TimeUtils.strDay()));
        return "key：success_order_"+TimeUtils.strDay()+"，value："+redisUtils.length("success_order_"+TimeUtils.strDay());
    }


    @RequestMapping(value = "clean/{key}",method = RequestMethod.GET)
    public String cleanRedis(@PathVariable("key") String key){
        redisUtils.clean(key+"_"+TimeUtils.strDay());
        System.out.println(redisUtils.pop("success_order_"+TimeUtils.strDay()));
        return "清除成功:"+redisUtils.length(key+"_"+TimeUtils.strDay());
    }


    @RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.POST)
    public String selectByPrimaryKey(Integer userId){
        log.info("测试输出日志......"+userId);
        return JSONObject.toJSONString(userService.selectByPrimaryKey(userId));
    }

    @RequestMapping(value = "userByUserId",method = RequestMethod.GET)
    public String userByUserId(Integer userId) {
        String data = restTemplate.getForObject("http://192.168.0.111:8765/userByUserId?userId="+userId,String.class);
        return data;
    }

}
