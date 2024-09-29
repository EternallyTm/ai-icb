package com.icb.chat.prompt;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;

import java.util.Arrays;

/**
 * prompt管理器
 */
public class PromptManage {

    public static Prompt ordinaryPrompt(String content) {
        SystemMessage systemMessage = new SystemMessage("请用欢快活跃的语气回复问题，如果你不知道，就直接回复不知道");
        UserMessage userMessage = new UserMessage(content);
        return new Prompt(Arrays.asList(systemMessage,userMessage));
    }
}
