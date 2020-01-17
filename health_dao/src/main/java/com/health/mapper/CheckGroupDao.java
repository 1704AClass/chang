package com.health.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;
import com.health.pojo.CheckGroup;
import com.health.pojo.CheckItem;

public interface CheckGroupDao {

	void add(CheckGroup checkGroup);

	void setCheckGroupAndCheckItem(Map map);

	CheckGroup findById(Integer id);

	List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
	
	void deleteAssociation(Integer id);

	void edit(CheckGroup checkGroup);

	Page<CheckItem> selectByCondition(String queryString);

}
