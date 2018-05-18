package com.junhao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.junhao.domain.User;
import com.junhao.mapper.UserMapper;
import com.junhao.service.UserService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService{    
    
    @Resource
    private UserMapper userMapper;
    
    @Transactional(readOnly=true)
    @Override
    public User login(String loginname, String password, String id) {
        
        return userMapper.finwithLoginnameAndPassword(loginname, password, id);
        
        //登录时在数据库查找对应的用户名和密码
        
    }
    @Override
    public void register(String loginname, String password, String username, String phone, String address) {
    	
    	userMapper.registerWithInfomation(loginname, password, username, phone, address);
    	
    }
	
  
    
}
