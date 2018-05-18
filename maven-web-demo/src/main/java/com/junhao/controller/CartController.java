package com.junhao.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.junhao.domain.User;
import com.junhao.service.GoodsService;

@Controller
public class CartController {

	@Resource
	GoodsService goodsService;
	
	@RequestMapping("Cartlist")
	public String cart(Model model,@RequestParam String userid) {
		
		String cartid = userid;
		model.addAttribute("cartgoods", goodsService.getCartGoods(cartid));
		
		
		
		return "cart";
		
	}
}
