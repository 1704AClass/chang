package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.constant.QueryPageBean;
import com.health.entity.PageResult;
import com.health.mapper.CheckItemMapper;
import com.health.pojo.CheckItem;
import com.health.service.CheckItemService;


@Service
public class CheckItemServiceImpl implements CheckItemService{
	
	@Autowired
	private CheckItemMapper	checkItemMapper;

	@Override
	public void add(CheckItem checkItem) {
		// TODO Auto-generated method stub
		checkItemMapper.add(checkItem);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		checkItemMapper.dels(id);
	}

	@Override
	public void edit(CheckItem checkItem) {
		// TODO Auto-generated method stub
		checkItemMapper.edit(checkItem);
	}

	@Override
	public CheckItem findById(Integer id) {
		// TODO Auto-generated method stub
		return checkItemMapper.findById(id);
	}

	@Override
	public List<CheckItem> findAll() {
		// TODO Auto-generated method stub
		return checkItemMapper.findAll();
	}

	@Override
	public PageResult pageQuery(QueryPageBean queryPageBean) {
		Integer currentPage = queryPageBean.getCurrentPage();
		Integer pageSize = queryPageBean.getPageSize();
		String queryString = queryPageBean.getQueryString();
		PageHelper.startPage(currentPage,pageSize);
		Page<CheckItem> page = checkItemMapper.pageQuery(queryString);
		long total = page.getTotal();
		List<CheckItem> rows = page.getResult();
		return new PageResult(total, rows);
	}
	@Override
	public void dels(Integer[] ids) {
		for (Integer id : ids) {
			checkItemMapper.dels(id);
		}
	}
}
