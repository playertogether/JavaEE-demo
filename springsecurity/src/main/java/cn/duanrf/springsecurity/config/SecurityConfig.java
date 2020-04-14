package cn.duanrf.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Author DRF
 * @Date 2020/4/13 11:11
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("duanrf").password("{noop}"+"123").roles("USER")
        .and()
        .withUser("zhangs").password("{noop}"+"123").roles("ADMIN");
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*
                 * mvcMatchers()
                 */
                .mvcMatchers("/index","/loginFail","/dologout").permitAll()//这些路径不需要保护
                .mvcMatchers("/order").hasRole("USER")//order需要USER角色
                .mvcMatchers("/product").hasAnyRole("USER","ADMIN")//product需要USER\ADMIN角色
                //.mvcMatchers("/loginSuccess").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")//自定义认证请求路径
                .successForwardUrl("/loginSuccess")//请求转发，浏览器地址不变
                //.defaultSuccessUrl("/loginSuccess")//重定向
                .failureForwardUrl("/loginFail")
                //.failureUrl("/loginFail")
                .and()
                .logout()
                .logoutUrl("/logout")//Spring Security内置自带的登出处理器
                .logoutSuccessUrl("/dologout")//登出成功url,重定向
                .and()
                .csrf().disable();//关闭csrf
    }

}
