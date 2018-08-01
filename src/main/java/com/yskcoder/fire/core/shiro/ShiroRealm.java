package com.yskcoder.fire.core.shiro;

import com.yskcoder.fire.core.shiro.service.IShiroService;
import com.yskcoder.fire.core.shiro.service.ShiroServiceImpl;
import com.yskcoder.fire.modular.system.model.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/24 15:07
 * @Description:自定义shiro用户认证
 */
public class ShiroRealm extends AuthorizingRealm {


    /**
     * 登录认证
     * @param authToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        IShiroService shiroService = ShiroServiceImpl.me();
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        SysUser user = shiroService.findUserByAccount(token.getUsername());
        ShiroUser shiroUser = shiroService.findShiroUserByUser(user);
        SimpleAuthenticationInfo info = shiroService.getAuthInfo(shiroUser, user, super.getName());
        return info;
    }

    /**
     * 权限认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        IShiroService shiroService = ShiroServiceImpl.me();
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<Integer> roleList = shiroUser.getRoleList();
        //路径权限
        Set<String> permissionSet = new HashSet<>();
        //角色权限
        Set<String> roleNameSet = new HashSet<>();

        for (Integer roleId : roleList) {
            List<String> permissions = shiroService.findPermissionsByRoleId(roleId);
            if (permissions != null) {
                for (String permission : permissions) {
                    if (permission != null && permission.length() > 0 ) {
                        permissionSet.add(permission);
                    }
                }
            }
            String roleName = shiroService.findRoleNameByRoleId(roleId);
            roleNameSet.add(roleName);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }


    /**
     * 设置密码加密方式
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher sha512CredentialsMatcher = new HashedCredentialsMatcher();
        sha512CredentialsMatcher.setHashAlgorithmName(ShiroUtil.algorithmName);
        sha512CredentialsMatcher.setHashIterations(ShiroUtil.iterations);
        super.setCredentialsMatcher(sha512CredentialsMatcher);
    }
}
