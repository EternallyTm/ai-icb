package com.icb.sso.handler;

import com.icb.sso.bo.SsoLoginResBO;
import com.icb.sso.bo.LoginBO;
import com.icb.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public abstract  class AbstractLoginHandler{

    @Autowired
    protected LoginService loginService;

    /**
     * 责任链，下一个链接节点
     */
    protected AbstractLoginHandler next = null;
    /**
     * 内部逻辑
     * @param model 登录入参
     * @return 登陆token及用户信息
     */
    public abstract SsoLoginResBO doHandler(LoginBO model);

    private void next(AbstractLoginHandler handler) {
        this.next = handler;
    }

    protected boolean hasNext() {
        return this.next != null;
    }

    public static class Builder {
        private AbstractLoginHandler head;
        private AbstractLoginHandler tail;

        public Builder addHandler(AbstractLoginHandler handler) {
            if (this.head == null) {
                this.head = handler;
                this.tail = handler;
            } else {
                this.tail.next(handler);
                this.tail = handler;
            }
            return this;
        }

        public AbstractLoginHandler build() {
            return this.head;
        }
    }
}
