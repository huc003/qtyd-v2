package com.qtyd.controller;

import com.qtyd.api.UserApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/17
 * @Description: 测试提供者服务
 **/
@RestController
@Api(value="onlinestore", description="用户操作")
public class UserController {

    @Autowired
    private UserApi userApi;

    @GetMapping("feign")
    @ApiOperation(value = "添加redis信息",httpMethod = "GET",notes = "添加redis信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID(非空)",required = true,dataType = "String",paramType = "query")
    })
    public String findByIdFeign(String id) {
        return userApi.addRedis(id);
    }

    @GetMapping("selectByPrimaryKey")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET",notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户ID(非空)",required = true,dataType = "Integer",paramType = "query")
    })
    public String selectByPrimaryKey(Integer userId){
        return userApi.selectByPrimaryKey(userId);
    }
}
