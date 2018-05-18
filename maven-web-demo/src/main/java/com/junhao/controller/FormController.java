package com.junhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		//视图控制器
public class FormController {

	@RequestMapping(value = "{formName}")

	public String Form(@PathVariable String formName) {
		// 动态跳转页面
		return formName;

	}



}