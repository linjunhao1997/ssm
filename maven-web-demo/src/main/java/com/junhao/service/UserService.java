package com.junhao.service;

import com.junhao.domain.User;

public interface UserService {
    
    User login(String Loginname,String password, String id);  //登录
    
    public void register(String loginname, String password, String username, String phone, String address);
    
   
    

}