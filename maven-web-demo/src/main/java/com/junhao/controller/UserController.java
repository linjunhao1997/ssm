package com.junhao.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.junhao.domain.User;
import com.junhao.service.UserService;

@Controller
public class UserController {    //用户控制器
    @Resource
    private UserService userService; 
    
    @RequestMapping(value="login")  //处理login请求
    public  ModelAndView login(String loginname,String password, String id,ModelAndView mv,HttpSession session){
    	User user = userService.login(loginname, password, id); //调用业务层方法返回一个实例对象
        if (user!=null) {  //判断查到的数据是否为空
            //如果用户不为空，设在Session域中
            session.setAttribute("user", user);
            mv.setView(new RedirectView("main")); //重定向到main页面中 
        }else {  
            mv.addObject("message","登录名或者密码错误");
            mv.setViewName("loginForm"); //重新设置view视图页面                  
        }  
        return mv; //返回视图
    }
    
    
    @RequestMapping(value="/register")  //注册
    public ModelAndView register(
    		@RequestParam String loginname,
    		@RequestParam String password,
    		@RequestParam String username,
    		@RequestParam String phone,
    		@RequestParam String address,
    		@Validated User user,BindingResult br,
    		ModelAndView mv)
    {	

    	
    	int errorCount = br.getErrorCount();
    	if(errorCount>0) {
    		FieldError loginnameError = br.getFieldError("loginname");
    		FieldError passwordError = br.getFieldError("password");
    		FieldError phoneError = br.getFieldError("phone");
    		
    		if(loginnameError!=null) {
    			String lnEmsg = loginnameError.getDefaultMessage();
    			mv.addObject("lnEmsg", lnEmsg);
    			//用户名格式错误
    		}
    		
    		if(passwordError!=null) {
    			String pwEmsg = passwordError.getDefaultMessage();
    			mv.addObject("pwEmsg", pwEmsg);
    			//密码格式错误
    		}
    		
    		if(phoneError!=null) {
    			String pEmsg = phoneError.getDefaultMessage();
    			mv.addObject("pEmsg", pEmsg);
    			//手机号码格式错误
    		}
    		
    		mv.setViewName("registerForm");
    		return mv;
    		
    	}
    	else {
    		
    		userService.register(loginname, password, username, phone, address);
    		mv.addObject("messge", "注册成功" );
    		mv.setViewName("registersuccess");
    		return mv;
    	}
    		
    }
    
}