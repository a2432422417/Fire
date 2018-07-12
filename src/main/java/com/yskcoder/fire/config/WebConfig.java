package com.yskcoder.fire.config;

import com.yskcoder.fire.core.filter.XssFilter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Auther: yskcoder
 * @Date: 2018/7/11 11:49
 * @Description:项目配置类
 */
@Configuration
public class WebConfig extends WebMvcAutoConfiguration {


    /**
     * xssFilter注册
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        XssFilter xssFilter = new XssFilter();
        FilterRegistrationBean registration = new FilterRegistrationBean(xssFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }



}
