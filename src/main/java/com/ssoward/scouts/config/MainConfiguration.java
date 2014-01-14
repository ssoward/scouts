package com.ssoward.scouts.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: ssoward
 * Date: 1/14/14
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableAutoConfiguration
//@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.ssoward.scouts"})
//@EnableCaching
public class MainConfiguration {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainConfiguration.class, args);
    }



    //security
    @Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return authenticationManager();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .formLogin().permitAll().and()
                    .authorizeRequests()
                    .antMatchers("/api/leaders*").hasRole("ADMIN") //url level security
                    .antMatchers("/api/scouts*").hasRole("USER");   //url level security
//                    .anyRequest().hasRole("USER");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("leader").password("password").roles("USER", "ADMIN").and()
                    .withUser("scout").password("password").roles("USER");
        }
    }


}
