package com.icb.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icb.dal.entity.ChatSessions;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatSessionsMapper extends BaseMapper<ChatSessions> {
    /**
     * 查询当前用户的聊天记录
     *
     * @param userId
     * @return
     */
    List<ChatSessions> selectByUserId(Long userId);
}