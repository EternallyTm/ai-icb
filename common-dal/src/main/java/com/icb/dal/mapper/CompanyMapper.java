package com.icb.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icb.dal.entity.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
}