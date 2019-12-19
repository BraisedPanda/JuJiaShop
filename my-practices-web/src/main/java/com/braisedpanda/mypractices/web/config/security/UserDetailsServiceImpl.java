package com.braisedpanda.mypractices.web.config.security;


import com.braisedpanda.mypractices.commons.model.User;
import com.braisedpanda.mypractices.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @program: admin-dashboard
 * @description:  通过用户名查找该角色信息

 * @create: 2019-11-21 09:12
 **/
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(username);
        if(user != null){
            String name = user.getUsername();
            String password = user.getPassword();
            int id = user.getId();
            SecurityUser userInfo=new SecurityUser(name, id ,password, "ROLE_ADMIN", 0,true,true, true,true);
            userInfo.setStatus(user.getStatus());
            return userInfo;
        }else
            return null;
    }
}




