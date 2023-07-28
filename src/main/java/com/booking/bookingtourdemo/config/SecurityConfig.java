package com.booking.bookingtourdemo.config;

import com.booking.bookingtourdemo.constant.PathLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public SecurityConfig() {
    }

    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("\n################## Init Spring Security Config ##################");
        http.csrf();
        ((HttpSecurity) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http.authorizeRequests()
                .antMatchers(PathLoader.loadPathsFromModule("logged")))
                .hasAnyRole(new String[]{"logged"})
                .antMatchers(PathLoader.loadPathsFromModule("out-of-login")))
                .permitAll().and()).formLogin().loginPage("/login");
        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl) http.authorizeRequests().antMatchers(PathLoader.loadPathsFromModule("landing-page")).permitAll().anyRequest()).denyAll();
        http.cors().and();
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedExceptionHandler());
        http.headers().httpStrictTransportSecurity().disable();
        System.out.println("################## Init Spring Security Config Successfully ##################");
    }

    public void configure(WebSecurity web) throws Exception {
        ((WebSecurity.IgnoredRequestConfigurer) ((WebSecurity.IgnoredRequestConfigurer) ((WebSecurity.IgnoredRequestConfigurer) ((WebSecurity.IgnoredRequestConfigurer) web.ignoring().antMatchers(new String[]{"/static/**"})).antMatchers(new String[]{"/static"})).antMatchers(new String[]{"/error/**"})).antMatchers(new String[]{"/error"})).antMatchers(new String[]{"/elb-check"});
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider();
        auth.authenticationProvider(provider);
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
