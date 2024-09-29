package com.icb.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.icb.dal.entity.ChatMessages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatMessagesMapper extends BaseMapper<ChatMessages> {
    /**
     * 查询当前用户当前会话的聊天记录
     *
     * @param userId
     * @param sessionId
     * @return
     */
    List<ChatMessages> selectByUserIdAndSessionId(@Param("userId") Long userId, @Param("sessionId") String sessionId);

    /**
     * 判断当前用户当前会话的聊天记录是否存在
     *
     * @param userId
     * @param sessionId
     * @return
     */
    boolean existedByUserIdAndSessionId(@Param("userId") Long userId, @Param("sessionId") Long sessionId);

    /**
     * 删除当前用户当前会话的聊天记录
     *
     * @param userId
     * @param sessionId
     */
    void deleteByUserIdAndSessionId(@Param("userId") Long userId, @Param("sessionId") Long sessionId);

    /**
     * 判断当前用户当前会话的聊天记录是否存在
     *
     * @param sessionId
     * @param sessionId
     * @return
     */
    boolean existedBySessionId(@Param("sessionId") String sessionId);

    /**
     * 删除当前用户当前会话的聊天记录
     *
     * @param sessionId
     */
    void deleteBySessionId(@Param("sessionId") String sessionId);
}