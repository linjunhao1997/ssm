package com.junhao.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class User{
		
	  
	  private int id;
	  
	  @NotBlank(message="登录名不能为空")
	  @Size(min=3,max=10,message="姓名长度应在{min}-{max}")
	  private String loginname;
	  
	 @NotBlank(message="密码不能为空")
	  @Length(min=6,max=15,message="密码长度必须在6位到15位之间")
	  private String password;
	  private String username;
	  
	 @NotEmpty(message="手机号码不允许为空")
	  @Pattern(regexp="^1[34578]\\d{9}$",message="手机号码格式不正确")
	  private String phone;
	  private String address;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	  
}
