//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.booking.bookingtourdemo.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedExceptionHandler implements AccessDeniedHandler {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public AccessDeniedExceptionHandler() {
    }

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String message = request.getRequestURI().concat("?");
        String queryString = request.getQueryString();
        this.LOGGER.info("Page Redirect: " + message + queryString);
        response.sendRedirect("/login?message=not_permission");
    }
}
