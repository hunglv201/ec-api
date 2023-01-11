package com.vn.ec.security.service.logout;

import com.vn.ec.security.jwt.JwtTokenUtil;
import net.jodah.expiringmap.ExpiringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class LoggedOutJwtTokenCache implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(LoggedOutJwtTokenCache.class);

    private final ExpiringMap<String, OnUserLogoutSuccessEvent> tokenEventMap;

    @Autowired
    private final JwtTokenUtil tokenProvider;

    @PostConstruct
    public void init() {
        tokenProvider.setLoggedOutJwtTokenCache(this);
    }

    @Autowired
    public LoggedOutJwtTokenCache(JwtTokenUtil tokenProvider) {
        this.tokenProvider = tokenProvider;
        this.tokenEventMap = ExpiringMap.builder().variableExpiration().maxSize(1000).build();
    }

    public void markLogoutEventForToken(OnUserLogoutSuccessEvent event) {
        String token = event.getToken();
        if (tokenEventMap.containsKey(token)) {
            logger.info("Log out token for user {} is already present in the cache", event.getLoginId());

        } else {
            Date tokenExpiryDate = tokenProvider.getTokenExpiryFromJWT(token);
            long ttlForToken = getTTLForToken(tokenExpiryDate);
            logger.info("Logout token cache set for {} with a TTL of {} seconds. Token is due expiry at {}",
                    event.getLoginId(), ttlForToken, tokenExpiryDate);
            tokenEventMap.put(token, event, ttlForToken, TimeUnit.SECONDS);
        }
    }

    public OnUserLogoutSuccessEvent getLogoutEventForToken(String token) {
        return tokenEventMap.get(token);
    }

    private long getTTLForToken(Date date) {
        long secondAtExpiry = date.toInstant().getEpochSecond();
        long secondAtLogout = Instant.now().getEpochSecond();
        return Math.max(0, secondAtExpiry - secondAtLogout);
    }
}
