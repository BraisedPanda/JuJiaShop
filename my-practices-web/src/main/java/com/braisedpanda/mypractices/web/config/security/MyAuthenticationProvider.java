package com.braisedpanda.mypractices.web.config.security;

import com.braisedpanda.mypractices.commons.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @program: admin-dashboard
 * @description: 验证用户名和密码是否正确，如果错误，抛出错误信息

 * @create: 2019-11-21 09:16
 **/
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    /**
     * 注入我们自己定义的用户信息获取对象
     */
    @Autowired
    private UserDetailsServiceImpl userDetailService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        String userName = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；
        String md5Pwd = MD5Utils.encrypt(password);
        // 这里构建来判断用户是否存在和密码是否正确
        SecurityUser userInfo = (SecurityUser) userDetailService.loadUserByUsername(userName); // 这里调用我们的自己写的获取用户的方法；

        if (userInfo == null) {
            throw new BadCredentialsException("*用户不存在");
        }

        if (!userInfo.getPassword().equals(md5Pwd)) {
            throw new BadCredentialsException("*密码不正确");
        }
        if(userInfo.getStatus() != 0 ){
            throw new BadCredentialsException("*用户状态被禁用");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
}