package com.icb.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icb.dal.entity.RoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {
    List<RoleUser> selectByUserId(@Param("userId") Long userId);
}