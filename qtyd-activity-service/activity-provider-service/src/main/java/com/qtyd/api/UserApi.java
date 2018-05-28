package com.qtyd.api;

import com.alibaba.fastjson.JSONObject;
import com.qtyd.service.UserService;
import com.qtyd.utils.RedisDefaultUtils;
import com.qtyd.utils.RedisOrderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Date: 2018/4/20 14:10
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

    @PostMapping("selectByPrimaryKey")
    public String selectByPrimaryKey(Integer userId) {
        log.info("测试输出日志......" + userId);
        return JSONObject.toJSONString(userService.selectByPrimaryKey(userId));
    }

    @RequestMapping(value = "userByUserId", method = RequestMethod.GET)
    public String userByUserId(Integer userId) {
        String data = restTemplate.getForObject("http://192.168.0.111:8765/userByUserId?userId=" + userId, String.class);
        return data;
    }

}
