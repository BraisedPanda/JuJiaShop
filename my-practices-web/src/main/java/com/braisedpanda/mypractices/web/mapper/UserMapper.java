package com.braisedpanda.mypractices.web.mapper;

import com.braisedpanda.mypractices.commons.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{
    String selectPasswordByEmail(String email);
}
