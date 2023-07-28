package com.booking.bookingtourdemo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

public class ThymeleafDispatcherServlet extends DispatcherServlet {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public ThymeleafDispatcherServlet() {
    }

    protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            super.render(mv, request, response);
        } catch (Exception var5) {
            this.LOGGER.error(ExceptionUtils.getStackTrace(var5));
            throw new Exception();
        }
    }
}
