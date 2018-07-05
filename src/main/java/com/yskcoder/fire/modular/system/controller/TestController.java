package com.yskcoder.fire.modular.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/3 17:55
 * @Description:Controller测试类
 */
@Controller
@RequestMapping("/fire")
public class TestController {

    @RequestMapping("")
    public String helloFire(){
        System.out.println("HelloFire");
       return "HelloFire";
    }

}
