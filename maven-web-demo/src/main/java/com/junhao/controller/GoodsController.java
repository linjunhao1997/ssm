package com.junhao.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.junhao.service.GoodsService;

@Controller
public class GoodsController {
	
	@Resource  
	GoodsService goodsService;
	
	
	@RequestMapping("main")  
	public String main(Model model,@RequestParam(required=false,defaultValue="1") int pageNO) {
		int size =1;   //每次查询一条记录
		
		model.addAttribute("size",size);
		model.addAttribute("pageNO",pageNO);
		
		model.addAttribute("goods", goodsService.getGoodsPager(pageNO, size));
		
		int count = goodsService.getGoodsCount();
		
		model.addAttribute("count",count);
		
		int beforepageNO=pageNO-1;
		
		String beforepage=Integer.toString(beforepageNO);
		if(beforepageNO>0) {
			model.addAttribute("previous","main?pageNO="+beforepage);//上一页
		}
		else
			model.addAttribute("previous","#");
		
		int nextpageNO = pageNO+1;
		
		String nextpage = Integer.toString(nextpageNO);
		
		if(pageNO<(count/size)) {
			model.addAttribute("next","main?pageNO="+nextpage);//上一页
		}
		else
			model.addAttribute("next","#");
		
		return "main";//返回的要对应好地址，不然视图层取不到值
	}
	
	//加入购物车
	@RequestMapping(value="addCart/userid/{userid}/goodid/{goodid}/goodname/{goodname}/price/{price}")  //加入购物车的触发方法
	public String addCart(ModelAndView mv,
			@PathVariable("userid") String userid, 
			String cartid, 
			@PathVariable("goodid") String goodid,
			@PathVariable("goodname") String goodname,
			@PathVariable("price") String price){
			mv.setViewName("Cart");
		    System.out.println(goodid);
		    String quantity = "1";
			cartid= userid;
			if(goodsService.isExist(goodid,cartid))//返回0条记录是false，>0是true
			{
				goodsService.updateQuantity(goodid,cartid); //已存在商品让数量加1
			}
			else {
				
				goodsService.insert(userid,cartid,goodid,goodname,price,quantity);
				//不存在则新增商品记录
			}
		
		return "success";
	}
}
