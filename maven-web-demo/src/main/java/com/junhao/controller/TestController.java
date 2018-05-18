package com.junhao.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.junhao.mapperxml.TestDao;
import com.junhao.service.GoodsService;

@Controller
public class TestController {

	@Resource  
	GoodsService goodsService;
	
	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String getHello(@RequestHeader("host") String hostName, @RequestHeader("Accept") String acceptType,
			@RequestHeader("Accept-Language") String acceptLang, @RequestHeader("Accept-Encoding") String acceptEnc,
			@RequestHeader("Cache-Control") String cacheCon, @RequestHeader("Cookie") String cookie,
			@RequestHeader("User-Agent") String userAgent) {
		System.out.println("Host : " + hostName);
		System.out.println("Accept : " + acceptType);
		System.out.println("Accept Language : " + acceptLang);
		System.out.println("Accept Encoding : " + acceptEnc);
		System.out.println("Cache-Control : " + cacheCon);
		System.out.println("Cookie : " + cookie);
		System.out.println("User-Agent : " + userAgent);
		return "index";
	}
	
	@RequestMapping("/testCookie")
	 public String testCookie(@CookieValue(value="name",required=false) String name,
	         @CookieValue(value="age",required=false) Integer age){
	     System.out.println(name+","+age);
	     return "index";
	 }
	
	@RequestMapping("test")
	 public String testDao() {
	       
	     System.out.println(goodsService.getGoodsCount());
	     return "index";
	 }
	
    @RequestMapping("test/upload")
    public String upload(@RequestParam("file") MultipartFile file ,HttpServletRequest request) throws IOException {
    	
    	long starttime = System.currentTimeMillis();
    	String filename=UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    	String path ="E:\\eclipse-workspace\\maven-web-demo\\src\\main\\webapp\\WEB-INF\\upload";
    	//下面的路径是tomcat的项目路径
    	//String path = request.getServletContext().getRealPath("/WEB-INF/upload");
    	System.out.println("filename:"+filename+starttime);
    	File uploadfile = new File(path,filename);
    	file.transferTo(uploadfile);
    	
    	return "success";
    }

}