package com.health.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.health.constant.MessageConstant;
import com.health.constant.QueryPageBean;
import com.health.entity.PageResult;
import com.health.entity.Result;
import com.health.pojo.CheckGroup;
import com.health.service.CheckGroupService;
/**
 *  
 * @author chw
 *
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
	@Reference
	private CheckGroupService checkGroupService;
	
	//新增
	@RequestMapping("/add")
	public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
		try{
			checkGroupService.add(checkGroup,checkitemIds);
		}catch(Exception e){
			return new Result(false,MessageConstant.ADD_CHECKGROUP_FAIL);
		}
		return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
	}
	//分页
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {

        PageResult pageResult = checkGroupService.pageQuery(queryPageBean.getCurrentPage(),queryPageBean.getPageSize(),queryPageBean.getQueryString());

        System.out.println(JSON.toJSONString(pageResult));

        return pageResult;
    }
    //查询一个
    @RequestMapping("/findById")
    public Result findById(Integer id){
    	CheckGroup checkGroup=checkGroupService.findById(id);
    	if(checkGroup!=null){
    		Result result=new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS);
    		result.setData(checkGroup);
    		return result;
    	}
    	return new Result(false, MessageConstant.QUERY_CHECKGROUP_FAIL);
    }
    
    //根据检查组合id查询对应的所有检查项id 
    @RequestMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(Integer id){
    	try {
			List<Integer> checkitemIds=checkGroupService.findCheckItemIdsByCheckGroupId(id);
			return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkitemIds); 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
		}
    }
    //编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
		try {
			checkGroupService.edit(checkGroup,checkitemIds);
		} catch (Exception e) {
			// TODO: handle exception
			return new Result(false, MessageConstant.EDIT_CHECKGROUP_FAIL);
		}
		return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }
    
}
