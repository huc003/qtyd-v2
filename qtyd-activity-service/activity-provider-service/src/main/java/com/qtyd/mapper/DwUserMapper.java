package com.qtyd.mapper;

import com.qtyd.pojo.domain.DwUser;
import java.util.List;

public interface DwUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(DwUser record);

    DwUser selectByPrimaryKey(Integer userId);

    List<DwUser> selectAll();

    int updateByPrimaryKey(DwUser record);
}