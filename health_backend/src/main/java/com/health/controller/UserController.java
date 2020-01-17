package com.health.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.pojo.User;
import com.health.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Reference
	UserService userService;
	
	
	
	@RequestMapping("/listAll")
	public List<User> listAll(){
		List<User> list=userService.list();
		return list;
	}
	
}
