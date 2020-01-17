package com.health.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.health.pojo.User;

public interface UserMapper {
	@Select("select * from t_user")
	List<User> list();

}
