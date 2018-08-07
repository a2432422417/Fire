package com.yskcoder.fire.core.shiro.service;

import cn.hutool.core.convert.Convert;
import com.yskcoder.fire.core.factory.impl.ConstantFactory;
import com.yskcoder.fire.core.shiro.ShiroUser;
import com.yskcoder.fire.core.util.SpringContextHolder;
import com.yskcoder.fire.modular.system.dao.MenuMapper;
import com.yskcoder.fire.modular.system.dao.UserMapper;
import com.yskcoder.fire.modular.system.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        ShiroUser shiroUser = new ShiroUser();

        shiroUser.setId(user.getId());
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptid());
        shiroUser.setDeptName(ConstantFactory.me().getDeptName(user.getDeptid()));
        shiroUser.setName(user.getName());

        Integer[] roleArray = Convert.toIntArray(user.getRoleid());
        List<Integer> roleList = new ArrayList<>();
        List<String> roleNames = new ArrayList<>();
        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNames.add(ConstantFactory.me().getRoleNameByRoleId(roleId));
        }
        shiroUser.setRoleList(roleList);
        return shiroUser;
    }

    @Override
    public List<String> findUrlListByRoleId(Integer roleId) {
        return ConstantFactory.me().findUrlListByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {
        return ConstantFactory.me().getRoleNameByRoleId(roleId);
    }

    @Override
    public SimpleAuthenticationInfo getShiroAuthInfo(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();

        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Sha512Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);

    }

}
