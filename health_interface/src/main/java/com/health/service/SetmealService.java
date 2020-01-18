package com.health.service;

import com.health.entity.PageResult;
import com.health.pojo.Setmeal;

public interface SetmealService {

	void add(Setmeal setmeal, Integer[] checkgroupIds);

	PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString);

}
