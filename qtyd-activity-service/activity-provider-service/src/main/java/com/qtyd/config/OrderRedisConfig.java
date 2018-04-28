package com.qtyd.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/28
 * @Description: 类描述
 **/
@Data
@Configuration
public class OrderRedisConfig extends RedisConfig{

    @Value("${spring.redis-order.database}")
    private Integer database;
    @Value("${spring.redis-order.host}")
    private String host;
    @Value("${spring.redis-order.port}")
    private Integer port;
    @Value("${spring.redis-order.timeout}")
    private Integer timeout;
    @Value("${spring.redis-order.password}")
    private String password;

    /**
     * @Author: 胡成
     * @Date:   2018/4/26 17:23
     * @Description: 获取redis连接
     **/
    @Bean
    public JedisConnectionFactory orderRedisConnectionFactory() {
        return newJedisConnectionFactory(database,host, port, timeout,password);
    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/26 17:23
     * @Description: 初始化订单RedisTemplate
     **/
    @Bean(name = "OrderRedisTemplate")
    public RedisTemplate orderRedisTemplate() {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(orderRedisConnectionFactory());
        setSerializer(template);
        template.afterPropertiesSet();
        return template;
    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/26 17:24
     * @Description: 初始化订单StringRedisTemplate
     **/
    @Bean(name = "OrderStringRedisTemplate")
    public StringRedisTemplate orderStringRedisTemplate() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(orderRedisConnectionFactory());
        template.afterPropertiesSet();
        return template;
    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/27 11:11
     * @Description: 消息监听容器,监听redis服务器中channel通道的信息写入
     * @param listenerAdapter 监听适配器1
     **/
//    @Bean
//    RedisMessageListenerContainer container(MessageListenerAdapter listenerAdapter,MessageListenerAdapter listenerAdapter2) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(orderRedisConnectionFactory());
//        //监听redis中一个channel通道
//        //这个container 可以添加多个 messageListener
//        container.addMessageListener(listenerAdapter, new PatternTopic(OrderTopicEnum.ORDER_TOPIC.getKey()));
//        container.addMessageListener(listenerAdapter2, new PatternTopic(OrderTopicEnum.ORDER_REFUND_TOPIC.getKey()));
//        return container;
//    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/27 11:10
     * @Description: 消息监听适配器,这个消息监听适配器是消息监听容器所需要的
     * @param receiver 订阅消息逻辑处理类
     **/
//    @Bean
//    MessageListenerAdapter listenerAdapter(MessageSubscribe receiver) {
//        //监听到消息反射调用receiver的receiveMessage方法
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

    /**
     * @Author: 胡成
     * @Date:   2018/4/27 11:10
     * @Description: 消息监听适配器,这个消息监听适配器是消息监听容器所需要的
     * @param receiver 订阅消息逻辑处理类
     **/
//    @Bean
//    MessageListenerAdapter listenerAdapter2(MessageSubscribe2 receiver) {
//        //监听到消息反射调用receiver的receiveMessage方法
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

}
