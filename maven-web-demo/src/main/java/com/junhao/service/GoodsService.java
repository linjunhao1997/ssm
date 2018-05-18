package com.junhao.service;

import java.util.List;

import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;

import com.junhao.domain.CartGoods;
import com.junhao.domain.Goods;

public interface GoodsService {
	
	//读取商品信息
	List<Goods> getGood();
	
	//读取购物车商品信息
	List<CartGoods> getCartGoods(String cartid);
	
	//添加到购物车
	int insert(String userid, String cartid, String goodid,String goodname,String price,String quantity);
	
	//获得商品总数
	int getGoodsCount();
	
	//分页
	List<Goods> getGoodsPager(int pageNO, int size);
	
    //单种商品数量
	String getQuantity(String goodid,String cartid);
    //判断商品是否已加入购物车
	boolean isExist(String goodid, String cartid);

	void updateQuantity(String goodid, String cartid);
	
}
