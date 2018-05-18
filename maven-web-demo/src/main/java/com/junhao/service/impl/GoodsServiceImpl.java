package com.junhao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.junhao.domain.CartGoods;
import com.junhao.domain.Goods;
import com.junhao.mapper.GoodsMapper;
import com.junhao.mapperxml.TestDao;
import com.junhao.service.GoodsService;

@Service("goodsService")

public class GoodsServiceImpl implements GoodsService {
	
	    @Resource
	    GoodsMapper goodsMapper; 
	    
	    @Resource
	    TestDao testDao;
	    
	    
	    

	    @Transactional(readOnly=true) //数据库的读取方式为：只读
	    @Override
	    public List<Goods> getGood() {
	        
	        return goodsMapper.findAll();
	    }
	    
	  //添加
	    @Override
		public int insert(String userid, String cartid, String goodid,String goodname,String price,String quantity) {
			return goodsMapper.insert(userid,cartid,goodid,goodname,price,quantity);
		}
		
		//获得商品总数
		@Override
		public int getGoodsCount() {
			return goodsMapper.getGoodsCount();
		}
		
		//分页
		@Override
		public List<Goods> getGoodsPager(int pageNO, int size) {
			int skip=(pageNO-1)*size;
			return goodsMapper.getGoodsPager(skip, size);
		}

		@Override
		public List<CartGoods> getCartGoods(String cartid) {
			return goodsMapper.getCartGoods(cartid);
		}

		@Override
		public String getQuantity(String goodid,String cartid) {
			return goodsMapper.getQuantity(goodid,cartid);
		}

		@Override
		public boolean isExist(String goodid,String cartid) {
			return goodsMapper.isGoodExist(goodid,cartid);
		}


		@Override
		public void updateQuantity(String goodid, String cartid) {
			 goodsMapper.updateQuantityBygoodidAndcartid(goodid,cartid);
		}

}

