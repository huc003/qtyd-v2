package com.qtyd.service.impl;

import com.qtyd.mapper.DwUserMapper;
import com.qtyd.pojo.domain.DwUser;
import com.qtyd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/23
 * @Description: 用户service
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private DwUserMapper userMapper;

    @Override
    public DwUser selectByPrimaryKey(Integer userId) {
        //PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectByPrimaryKey(userId);
    }
}
