package com.qtyd.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/23
 * @Description: 数据库配置
 **/
@Configuration
public class DataBaseConfig {
    public static void main(String[] args) {

    }

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));

        // 分页插件
        PageHelper pageHelper = new PageHelper();
        Properties props = new Properties();
        props.setProperty("reasonable", "true");
        pageHelper.setProperties(props);
        // 添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});

        return sqlSessionFactoryBean.getObject();
    }
}
