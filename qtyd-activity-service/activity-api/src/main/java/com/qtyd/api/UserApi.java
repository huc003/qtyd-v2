package com.qtyd.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/17
 * @Description: 通过FeignClient将提供者服务暴露
 **/
@FeignClient(name = "activity-provider-service")
public interface UserApi {
    @RequestMapping("/user/add/{id}")
    String addRedis(@RequestParam("id") String id);

    @RequestMapping("/user/selectByPrimaryKey")
    String selectByPrimaryKey(@RequestParam("userId") Integer userId);
}
