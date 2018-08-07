package com.yskcoder.fire.core.factory.impl;

import com.yskcoder.fire.core.factory.IConstantFactory;
import com.yskcoder.fire.core.util.SpringContextHolder;
import com.yskcoder.fire.modular.system.dao.DeptMapper;
import com.yskcoder.fire.modular.system.dao.MenuMapper;
import com.yskcoder.fire.modular.system.dao.RoleMapper;
import com.yskcoder.fire.modular.system.dao.UserMapper;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: yskcoder
 * @Date: 2018/8/7 10:27
 * @Description:Fire
 */
@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory{
    private RoleMapper roleMapper = SpringContextHolder.getBean(RoleMapper.class);
    private DeptMapper deptMapper = SpringContextHolder.getBean(DeptMapper.class);
    private UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);
    private MenuMapper menuMapper = SpringContextHolder.getBean(MenuMapper.class);

    //静态调用bean
    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    @Override
    public String getDeptName(Integer deptId) {
        return null;
    }

    public String getRoleNameByRoleId(Integer roleId){
        return  null;
    }

    @Override
    public List<String> findUrlListByRoleId(Integer roleId) {
        return null;
    }
}
