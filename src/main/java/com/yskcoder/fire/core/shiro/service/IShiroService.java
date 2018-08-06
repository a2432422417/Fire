package com.yskcoder.fire.core.shiro.service;

import com.yskcoder.fire.core.shiro.ShiroUser;
import com.yskcoder.fire.modular.system.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/24 12:00
 * @Description:Shiro用户相关
 */
public interface IShiroService {

    /**
     * 根据账号获取登录用户
     * @param account
     * @return
     */
    User findUserByAccount(String account);

    /**
     * 根据系统用户获取shiro用户
     * @param user
     * @return
     */
    ShiroUser findShiroUserByUser(User user);

    /**
     * 根据角色id获取权限列表
     * @param roleId
     * @return
     */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
     * 根据角色id获取角色名称
     * @param roleId
     * @return
     */
    String findRoleNameByRoleId(Integer roleId);

    /**
     * 获取shiro的认证信息
     * @param shiroUser
     * @param user
     * @param realmName
     * @return
     */
    SimpleAuthenticationInfo getAuthInfo(ShiroUser shiroUser, User user, String realmName);
}
