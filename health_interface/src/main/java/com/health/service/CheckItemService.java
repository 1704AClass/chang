package com.health.service;

import java.util.List;

import com.health.constant.QueryPageBean;
import com.health.entity.PageResult;
import com.health.pojo.CheckItem;

public interface CheckItemService {

	void add(CheckItem checkItem);

	PageResult pageQuery(QueryPageBean queryPageBean);

	void delete(Integer id);

	void edit(CheckItem checkItem);

	CheckItem findById(Integer id);

	List<CheckItem> findAll();

	void dels(Integer[] ids);

}
