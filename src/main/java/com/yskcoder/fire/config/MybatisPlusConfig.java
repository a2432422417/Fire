package com.yskcoder.fire.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

import com.yskcoder.fire.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
* @Description: MybatisPlus配置类
* @Author:      yskcoder
* @CreateDate:  2018/7/4 17:30
*/
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.yskcoder.fire.modular.*.dao"})
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;


    /**
     * Druid数据源
     */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
