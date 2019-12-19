package com.braisedpanda.mypractices.web.service.impl;

import com.braisedpanda.mypractices.commons.model.CommonsResult;
import com.braisedpanda.mypractices.commons.model.User;
import com.braisedpanda.mypractices.commons.utils.MD5Utils;
import com.braisedpanda.mypractices.web.mapper.UserMapper;
import com.braisedpanda.mypractices.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-16 14:05
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    
    /** 
    * @Description:  插入用户
    * @Param: [user]
    * @Date: 2019/12/16 0016 
    */ 
    @Override
    public CommonsResult insertUser(User user) {
        int i =userMapper.insert(user);
        if(i>0){
            return CommonsResult.success("*注册用户成功");
        }
        return CommonsResult.failed("*注册用户失败");
    }

    /** 
    * @Description: 检查是否有重复邮箱 
    * @Param: [email]
    * @Date: 2019/12/16 0016 
    */ 
    @Override
    public CommonsResult checkEmail(String email) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email",email);
        List<User> userList = userMapper.selectByExample(example);
        if(userList.size()>0){
            return CommonsResult.failed("*该邮箱已经被注册");
        }
        return CommonsResult.success();
    }
    
    /** 
    * @Description: 在数据库中查找用户
    * @Param: [user]
    * @Date: 2019/12/16 0016 
    */ 
    @Override
    public CommonsResult selectUser(User user) {
        String email = user.getEmail();
        String password = userMapper.selectPasswordByEmail(email);
        if(MD5Utils.encrypt(user.getPassword()).equals(password)){
            return CommonsResult.success();
        }else{
            return CommonsResult.failed("*用户名或密码错误");
        }
    }
    
    /** 
    * @Description: 通过邮箱获取用户
    * @Param: 
    * @Date: 2019/12/17 0017 
    */
    @Override
    public User getUserByEmail(String email) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("email",email);
        User user = userMapper.selectOneByExample(example);
        return user;
    }
}
