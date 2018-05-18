package com.junhao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ValidateMapper {

    @Select("select count(loginname) from tb_user where loginname=#{loginname} ") 
    boolean getloginname(@Param(value="loginname") String loginname);  //验证注册的用户名是否已存在

}