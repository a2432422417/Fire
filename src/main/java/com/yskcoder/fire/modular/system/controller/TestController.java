package com.yskcoder.fire.modular.system.controller;

import com.yskcoder.fire.modular.system.model.SysUser;
import com.yskcoder.fire.modular.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    ISysUserService sysUserService;

    @RequestMapping("")
    public String helloFire(){
        SysUser sysUser = new SysUser();
        sysUser.setAccount("admin");
        sysUser.setName("小明");
        sysUserService.insertOrUpdate(sysUser);
        System.out.println("HelloFire");
        return "HelloFire";
    }

}
