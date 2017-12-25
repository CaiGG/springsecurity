package com.springsecurity.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 创建过滤器
 * 第一步，是使用Java代码创建Spring Security的配置。这段配置创建一个Servlet Filter：springSecurityFilterChain，
 * 其负责应用中的所有安全，包括：保护应用的URLS，验证提交的username和password，重定向到登录页面等。
 * 方法名 configureGlobal是无关紧要的，重要的是在一个添加了 @EnableWebSecurity, @EnableGlobalMethodSecurity或者
 *  @EnableGlobalAuthentication注解的类里面，注入 AuthenticationManagerBuilder。
 * 这段代码内容很少，但事实上已经做了很多的默认安全验证，包括：
 * 1、访问应用中的每个URL都需要进行验证
 * 2、生成一个登陆表单
 * 3、允许用户使用username和password来登陆
 * 4、允许用户注销
 * 5、CSRF攻击拦截
 * 6、 Session Fixation攻击
 * 7、 安全Header集成
 *
 */

/*@EnableWebSecurity*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http ) throws  Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()//访问index.html不要权限验证
                .anyRequest().authenticated()//其他所有路径都需要权限校验
                .and()
                .csrf().disable()//默认开启，这里先显式关闭
                .formLogin()  //内部注册 UsernamePasswordAuthenticationFilter
                .loginPage("/login") //表单登录页面地址
                .loginProcessingUrl("/login")//form表单POST请求url提交地址，默认为/login
                .passwordParameter("password")//form表单用户名参数名
                .usernameParameter("username") //form表单密码参数名
                .defaultSuccessUrl("/")//如果用户没有访问受保护的页面，默认跳转到页面
                //.successForwardUrl("/jsp/privilege.jsp")  //登录成功跳转地址
                //.failureForwardUrl("/error") //登录失败跳转地址
                //.failureUrl()
                //.failureHandler(AuthenticationFailureHandler)
                //.successHandler(AuthenticationSuccessHandler)
                //.failureUrl("/login?error")
                .permitAll()//允许所有用户都有权限访问登录页面
                .and()
                //提供注销支持，当使用 WebSecurityConfigurerAdapter时这将会被自动应用
                .logout()
                //触发注销操作的url，默认是/logout。如果开启了CSRF保护(默认开启),那么请求必须是POST方式。
                .logoutUrl("/my/logout")
                //注销操作发生后重定向到的url，默认为 /login?logout。
                .logoutSuccessUrl("/")
                //让你指定自定义的 LogoutSuccessHandler。如果指定了， logoutSuccessUrl() 将会被忽略
                /*.logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                    }
                })*/
                //添加一个 LogoutHandler。默认情况下， SecurityContextLogoutHandler 被作为最后一个 LogoutHandler 。
                /*.addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

                    }
                })*/
                //指定在注销的时候是否销毁 HttpSession 。默认为True。
                .invalidateHttpSession(true)
                //允许指定当注销成功时要移除的cookie的名称。这是显式店家 CookieClearingLogoutHandler 的一种快捷处理方式
                /*.deleteCookies("cookieNamesToClear")*/
                .permitAll();
    }
}

