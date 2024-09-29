package com.icb.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icb.dal.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByUsername(String username);
}