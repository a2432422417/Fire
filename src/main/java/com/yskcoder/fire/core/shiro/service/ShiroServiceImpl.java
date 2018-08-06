package com.yskcoder.fire.core.shiro.service;

import com.yskcoder.fire.core.shiro.ShiroUser;
import com.yskcoder.fire.core.util.SpringContextHolder;
import com.yskcoder.fire.modular.system.dao.MenuMapper;
import com.yskcoder.fire.modular.system.dao.UserMapper;
import com.yskcoder.fire.modular.system.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/24 12:00
 * @Description: shiro用户相关实现类
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroServiceImpl implements IShiroService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MenuMapper menuMapper;

    /**
     * 静态方式获取IShiroService的Bean
     * @return
     */
    public static IShiroService me() {
        return SpringContextHolder.getBean(IShiroService.class);
    }

    @Override
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    @Override
    public ShiroUser findShiroUserByUser(User user) {
        return null;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public SimpleAuthenticationInfo getAuthInfo(ShiroUser shiroUser, User user, String realmName) {
        return null;
    }

}
