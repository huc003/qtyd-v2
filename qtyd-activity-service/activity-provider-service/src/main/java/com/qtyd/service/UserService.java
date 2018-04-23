package com.qtyd.service;

import com.qtyd.pojo.domain.DwUser;

/**
 * @Author: 胡成
 * @Version: 0.0.1V
 * @Date: 2018/4/23
 * @Description: 类描述
 **/
public interface UserService {
    DwUser selectByPrimaryKey(Integer userId);
}
