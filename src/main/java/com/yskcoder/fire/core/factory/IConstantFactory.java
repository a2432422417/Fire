package com.yskcoder.fire.core.factory;

import java.util.List;

/**
 * @Auther: admin
 * @Date: 2018/8/7 10:31
 * @Description:Fire常用方法类
 */
public interface IConstantFactory {

    /**
     * 根据部门id获取部门名称
     * @param deptId
     * @return
     */
     String getDeptName(Integer deptId);


    /**
     * 根据roleId获取角色名称
     * @param roleId
     * @return
     */
     String getRoleNameByRoleId(Integer roleId);


    /**
     * 根据roleId获取路径权限
     * @param roleId
     * @return
     */
     List<String> findUrlListByRoleId(Integer roleId);



}
