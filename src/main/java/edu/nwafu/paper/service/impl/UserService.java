package edu.nwafu.paper.service.impl;

import edu.nwafu.paper.beans.User;
import edu.nwafu.paper.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username,String password){
        User user = userMapper.login(username, password);
        return user;
    }
}
