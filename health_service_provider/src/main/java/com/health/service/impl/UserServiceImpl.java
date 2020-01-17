package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.health.mapper.UserMapper;
import com.health.pojo.User;
import com.health.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> list() {
		return userMapper.list();
	}

}
