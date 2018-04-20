package com.qtyd.api;

import com.qtyd.utils.RedisUtils;
import com.qtyd.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 胡成
 * @Date:   2018/4/20 14:10
 * @Description: 服务提供者具体的实现
**/
@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private RedisUtils redisUtils;

//    @RequestMapping(value="/add/{id}", method= RequestMethod.GET)
    @GetMapping("add/{id}")
    public String addRedis(@PathVariable("id") String id){
        System.out.println("------"+id);
        //获取当天日期
        redisUtils.lpush("success_order_"+TimeUtils.strDay(),"{user_id:"+id+",order_id:123123123,add_time:1523859194}");
        System.out.println("---------"+redisUtils.length("success_order_"+TimeUtils.strDay()));
//        System.out.println("从redis取出数据:"+redisUtils.pop("success_order_"+TimeUtils.strDay()));
        return "key：success_order_"+TimeUtils.strDay()+"，value："+redisUtils.length("success_order_"+TimeUtils.strDay());
    }


    @RequestMapping(value = "clean/{key}",method = RequestMethod.GET)
    public String cleanRedis(@PathVariable("key") String key){
        redisUtils.clean(key+"_"+TimeUtils.strDay());
        System.out.println(redisUtils.pop("success_order_"+TimeUtils.strDay()));
        return "清除成功:"+redisUtils.length(key+"_"+TimeUtils.strDay());
    }
}
