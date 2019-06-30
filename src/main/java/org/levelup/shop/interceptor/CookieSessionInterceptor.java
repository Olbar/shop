package org.levelup.shop.interceptor;


import org.levelup.shop.service.AuthorizationSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieSessionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private AuthorizationSessionService authSessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.sendRedirect("/login");
            return false;
        }

        // Cookie
        // getName()
        // getValue()
        Optional<Cookie> possibleCookie = Arrays.stream(cookies)
                .filter(c -> c.getName().equals("WC_SESSION"))
                .findFirst();
        if (!possibleCookie.isPresent()) {
            response.sendRedirect("/login");
            return false;
        }

        if (authSessionService.isExpired(possibleCookie.get().getValue())) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}
