package com.junhao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.junhao.domain.CartGoods;
import com.junhao.domain.Goods;

public interface GoodsMapper {
	@Select("select * from tb_goods")   
    List<Goods> findAll();  //查询商品表的所有商品信息

	
	 //添加到购物车
  	@Insert("insert into cart_goods(userid,cartid,goodid,goodname,price,quantity) values(#{userid},#{cartid},#{goodid},#{goodname},#{price},#{quantity})")
  	public int insert(
  			@Param(value = "userid") String userid, 
  			@Param(value = "cartid") String cartid, 
  			@Param(value = "goodid") String goodid,
  			@Param(value = "goodname") String goodname,
  			@Param(value = "price") String price,
  			@Param(value ="quantity") String quantity
  			);	//加入购物车时存储用户id,购物车id,商品id
  	
  	/**
	 * 获得商品信息并分页
	 */
  	@Select("select * from tb_goods limit #{skip},#{size}")
	public List<Goods> getGoodsPager(@Param("skip") int skip,@Param("size") int size);
  	
  	@Select("select count(*) from tb_goods")
  	public int getGoodsCount();

    //显示购物车清单
  	@Select("select * from cart_goods where cartid = #{cartid}")
	List<CartGoods> getCartGoods(String cartid);

    //单种商品的数量
  	@Select("select quantity form cart_goods where cartid=#{cartid} and goodid=#{goodid}")
	String getQuantity(@Param("goodid") String goodid,@Param("cartid") String cartid);

    @Select("select count(#{goodid}) from cart_goods where cartid=#{cartid}")
	boolean isGoodExist(@Param("goodid") String goodid,@Param("cartid") String cartid);
    
    
    @Update("update cart_goods set quantity=quantity+1 where goodid=#{goodid} and cartid=#{cartid}")
    void updateQuantityBygoodidAndcartid(@Param("goodid")String goodid,@Param("cartid")String cartid);
}
