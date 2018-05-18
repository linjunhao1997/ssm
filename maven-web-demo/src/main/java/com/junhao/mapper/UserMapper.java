package com.junhao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.junhao.domain.User;

public interface UserMapper {

    @Select("select * from tb_user where loginname=#{loginname} and password=#{password}") //以#{}的方式表示sql中的参数
    User finwithLoginnameAndPassword(@Param("loginname")String loginname,@Param("password")String password, String id);//@param表示上面sql中的参数
    
   
    
    @Insert("insert into tb_user(loginname,password,username,phone,address) values(#{loginname},#{password},#{username},#{phone},#{address})")
    void registerWithInfomation(
    		@Param("loginname")String loginname,
    		@Param("password")String password,
    		@Param("username")String username,
    		@Param("phone")String phone,
    		@Param("address")String address);
    
    @Insert("insert into cart_goods(userid,cartid,goodid) value(#{userid},#{cartid},#{goodid})")
    void addToCart(int userid, int cartid, int goodid );
}