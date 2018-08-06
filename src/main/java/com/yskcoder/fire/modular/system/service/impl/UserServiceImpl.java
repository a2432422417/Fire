package com.yskcoder.fire.modular.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yskcoder.fire.modular.system.dao.UserMapper;
import com.yskcoder.fire.modular.system.model.User;
import com.yskcoder.fire.modular.system.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Auther: yskcoder
 * @Date: 2018/7/11 10:57
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


}
