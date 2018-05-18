package com.junhao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.junhao.mapper.ValidateMapper;
import com.junhao.service.ValidateService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("validateService")
public class ValidateServiceImpl implements ValidateService{    //表示service层
    
    @Resource
    private ValidateMapper validateMapper;
    
   
	@Override
    @Transactional(readOnly=true) //数据库的读取方式为：只读
    public boolean isloginnameexist(String loginname) {
        
        return validateMapper.getloginname(loginname);
    }
    
}
