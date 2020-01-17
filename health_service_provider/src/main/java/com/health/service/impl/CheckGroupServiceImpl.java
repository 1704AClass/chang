package com.health.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.constant.QueryPageBean;
import com.health.entity.PageResult;
import com.health.mapper.CheckGroupDao;
import com.health.pojo.CheckGroup;
import com.health.pojo.CheckItem;
import com.health.service.CheckGroupService;

@Service
public class CheckGroupServiceImpl implements CheckGroupService{
	@Autowired
	private CheckGroupDao checkGroupDao;
	@Override
	public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
		checkGroupDao.add(checkGroup);
	}
	//向中间表插入数据
	public void setCheckGroupAndCheckItem(Integer checkGroupId,Integer[] checkitemIds){
		if(checkitemIds!=null && checkitemIds.length>0){
			for (Integer checkitemId : checkitemIds) {
				Map<String, Integer> map=new HashMap<>();
				map.put("checkgroup_id", checkGroupId);
				map.put("checkitem_id", checkitemId);
				checkGroupDao.setCheckGroupAndCheckItem(map);
			}
		}
	}
	@Override
	public CheckGroup findById(Integer id) {
		// TODO Auto-generated method stub
		return checkGroupDao.findById(id);
	}
	@Override
	public List<Integer> findCheckItemIdsByCheckGroupId(Integer id) {
		// TODO Auto-generated method stub
		return checkGroupDao.findCheckItemIdsByCheckGroupId(id); 
	}
	@Override
	public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
		checkGroupDao.deleteAssociation(checkGroup.getId()); 
		setCheckGroupAndCheckItem(checkGroup.getId(),checkitemIds);
		checkGroupDao.edit(checkGroup); 
	}
	@Override
	public PageResult pageQuery(Integer currentPage, Integer pageSize, String queryString) {
		PageHelper.startPage(currentPage,pageSize);
		Page<CheckItem> page=checkGroupDao.selectByCondition(queryString);
		return new PageResult(page.getTotal(),page.getResult());
	}
	
}
