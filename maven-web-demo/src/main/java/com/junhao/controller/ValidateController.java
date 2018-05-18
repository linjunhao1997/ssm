package com.junhao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junhao.domain.User;
import com.junhao.domain.Validate;
import com.junhao.service.ValidateService;

@Controller
public class ValidateController {
	
	@Resource
	ValidateService validateservice;

	@RequestMapping("/action/validate") // 用json的传入和传出实现ajax
	public @ResponseBody Validate validate(@RequestBody User user) {

		String loginname = user.getLoginname();
		boolean isexist = validateservice.isloginnameexist(loginname);

		Validate v = new Validate();
		System.out.println(isexist);

		if (!isexist) {
			v.setMessage("该用户名可用！");
			return v;
		}

		else {
			v.setMessage("该用名户名已被注册");
			return v;
		}
	}
}
