package com.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author : chenjie
 * @date : 2018-12-25 16:03
 * @describe :
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /** 自定义用户信息 **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //密码编码器
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //使用内存存储
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
                .withUser("admin").password("$2a$10$jXy0kJY.lBX1lZgV8LUV8O./nRdKw9VreRKu42cEkM1ZlUhYznWk6").roles("USER", "ADMIN");
    }

}
