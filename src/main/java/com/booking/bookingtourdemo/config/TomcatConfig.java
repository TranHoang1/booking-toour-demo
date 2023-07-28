package com.booking.bookingtourdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {
    @Value("${custom.config.tomcat.context-path}")
    private String contextPath;
    @Value("${custom.config.tomcat.port}")
    private int port;

    public TomcatConfig() {
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        System.out.println("\n################## Init Tomcat Config ##################");
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
        factory.setContextPath(this.contextPath);
        factory.setPort(this.port);
        System.out.println("################## Init Tomcat Config Successfully ##################");
        return factory;
    }
}

