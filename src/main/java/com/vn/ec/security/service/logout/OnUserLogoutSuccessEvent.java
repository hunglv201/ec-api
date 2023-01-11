package com.vn.ec.security.service.logout;

import com.vn.ec.dto.request.LogOutRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
public class OnUserLogoutSuccessEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private final String loginId;
    private final String token;
    private final transient LogOutRequest logOutRequest;
    private final Date eventTime;

    public OnUserLogoutSuccessEvent(String loginId, String token, LogOutRequest logOutRequest) {
        super(loginId);
        this.loginId = loginId;
        this.token = token;
        this.logOutRequest = logOutRequest;
        this.eventTime = Date.from(Instant.now());
    }
}
