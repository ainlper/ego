package com.ego.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码解析器
     *
     * @return
     */
    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().
                loginProcessingUrl("/login")//自定义登录逻辑
                .successForwardUrl("/loginSuccess")
                .loginPage("/");//登录页面

        //配置放行
        http.authorizeRequests()
                //放行静态资源
                .antMatchers("/", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();

        http.csrf().disable();
    }
}
