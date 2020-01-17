package com.health.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.github.pagehelper.Page;
import com.health.pojo.CheckItem;


public interface CheckItemMapper {
	Page<CheckItem> pageQuery(String queryString);
	@Insert("insert into t_checkitem set code=#{code},name=#{name},sex=#{sex},age=#{age},price=#{price},type=#{type},remark=#{remark},attention=#{attention}")
	void add(CheckItem checkItem);
	@Delete("delete from t_checkitem where id=#{id}")
	void dels(Integer id);
	@Update("update t_checkitem set code=#{code},name=#{name},sex=#{sex},age=#{age},price=#{price},type=#{type},remark=#{remark},attention=#{attention} where id=#{id}")
	void edit(CheckItem checkItem);
	@Select("select * from t_checkitem where id=#{id}")
	CheckItem findById(Integer id);
	List<CheckItem> findAll();
	
}
