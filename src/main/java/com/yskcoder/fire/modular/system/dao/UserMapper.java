package com.yskcoder.fire.modular.system.dao;

import com.yskcoder.fire.modular.system.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author yskcoder123
 * @since 2018-08-06
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过账号获取用户
     * @param account
     * @return
     */
    User findUserByAccount(@Param("account") String account);

}
