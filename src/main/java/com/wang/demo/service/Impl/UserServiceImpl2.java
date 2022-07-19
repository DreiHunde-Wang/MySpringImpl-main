package com.wang.demo.service.Impl;

import com.wang.demo.dao.UserMapper;
import com.wang.spring.annotation.ioc.Autowired;
import com.wang.spring.annotation.ioc.Service;


@Service
public class UserServiceImpl2 {
	@Autowired
	public UserServiceImpl userService;
	
	@Autowired
	UserMapper userMapper;
}
