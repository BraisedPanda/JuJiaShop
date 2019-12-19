package com.braisedpanda.mypractices.web.service;

import com.braisedpanda.mypractices.commons.model.CommonsResult;
import com.braisedpanda.mypractices.commons.model.User;

public interface UserService {
    CommonsResult insertUser(User user);

    CommonsResult checkEmail(String email);

    CommonsResult selectUser(User user);

    User getUserByEmail(String email);
}
