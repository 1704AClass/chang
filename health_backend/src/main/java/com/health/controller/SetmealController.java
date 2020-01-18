package com.health.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.health.constant.MessageConstant;
import com.health.constant.QueryPageBean;
import com.health.constant.RedisConstant;
import com.health.entity.PageResult;
import com.health.entity.Result;
import com.health.pojo.Setmeal;
import com.health.service.SetmealService;
import com.health.utils.QiniuUtils;

import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
	@Reference
	private SetmealService setmealService;
	@Autowired
	private JedisPool jedisPool;
	//上傳
	@RequestMapping("/upload")
	public Result upload(@RequestParam("imgFile")MultipartFile imgFile){
		try {
			String originalFilename=imgFile.getOriginalFilename();
			int lastIndexOf=originalFilename.lastIndexOf(".");
			String suffix=originalFilename.substring(lastIndexOf-1);
			String fileName=UUID.randomUUID().toString()+suffix;
			QiniuUtils.upload2Qiniu(imgFile.getBytes(), fileName);
			Result result=new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS);
			result.setData(fileName);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
		}
	}
	//新增
	@RequestMapping("/add")
	public Result add(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){
		try {
			setmealService.add(setmeal,checkgroupIds);
		} catch (Exception e) {
			// TODO: handle exception
			//新增失败 
			return new Result(false, MessageConstant.ADD_SETMEAL_FAIL);
		}
		//新增成功
		return new Result(true, MessageConstant.ADD_SETMEAL_SUCCESS);
	}
	//分页查
	@RequestMapping("/findPage")
	public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = setmealService.pageQuery(queryPageBean.getCurrentPage(),queryPageBean.getPageSize(),queryPageBean.getQueryString());
        System.out.println(JSON.toJSONString(pageResult));
        return pageResult;
    }
}
