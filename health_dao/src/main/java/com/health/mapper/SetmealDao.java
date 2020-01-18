package com.health.mapper;

import java.util.Map;

import com.github.pagehelper.Page;
import com.health.pojo.Setmeal;

public interface SetmealDao {

	void add(Setmeal setmeal);

	void setSetmealAndCheckGroup(Map<String, Integer> map);

	Page<Setmeal> selectByCondition(String queryString);
	
}
