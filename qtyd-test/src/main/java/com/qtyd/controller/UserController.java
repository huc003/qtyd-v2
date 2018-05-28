package com.qtyd.controller;

import com.alibaba.fastjson.JSONObject;
import com.qtyd.api.UserApi;
import feign.Param;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/17
 * @Description: 测试提供者服务
 **/
@RestController
@Api(value = "onlinestore", description = "用户操作")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserApi userApi;

    @PostMapping("selectByPrimaryKey")
    @ApiOperation(value = "获取用户信息", httpMethod = "POST", notes = "获取用户信息")
    public String selectByPrimaryKey(@ApiParam(required = true, value = "用户userid") @RequestParam Integer userId) {
        return userApi.selectByPrimaryKey(userId);
    }

    @GetMapping("userByUserId")
    @ApiOperation(value = "获取用户信息", httpMethod = "GET", notes = "从service里获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID(非空)", required = true, dataType = "int", paramType = "query")
    })
    public String userByUserId(Integer userId) {
        MultiValueMap<String,Object> map = new LinkedMultiValueMap<>();
        map.add("userId",userId);
        String data = restTemplate.postForObject("http://192.168.0.111:8762/user/selectByPrimaryKey",map,String.class);
        return data;
    }


}
