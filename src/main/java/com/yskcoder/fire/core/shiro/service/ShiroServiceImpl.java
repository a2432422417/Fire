package com.yskcoder.fire.core.shiro.service;

import com.yskcoder.fire.core.shiro.ShiroUser;
import com.yskcoder.fire.core.util.SpringContextHolder;
import com.yskcoder.fire.modular.system.dao.SysMenuMapper;
import com.yskcoder.fire.modular.system.dao.SysUserMapper;
import com.yskcoder.fire.modular.system.model.SysUser;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/24 12:00
 * @Description:
 */
@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroServiceImpl implements IShiroService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysMenuMapper sysMenuMapper;

    /**
     * 静态方式获取IShiroService的Bean
     * @return
     */
    public static IShiroService me() {
        return SpringContextHolder.getBean(IShiroService.class);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        return sysUserMapper.findUserByAccount(account);
    }

    @Override
    public ShiroUser findShiroUserByUser(SysUser user) {
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
    public SimpleAuthenticationInfo getAuthInfo(ShiroUser shiroUser, SysUser user, String realmName) {
        return null;
    }

}
