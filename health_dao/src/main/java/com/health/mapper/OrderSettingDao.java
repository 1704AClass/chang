package com.health.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.health.pojo.OrderSetting;

public interface OrderSettingDao {

	void add(OrderSetting orderSetting);

	void editNumberByOrderDate(OrderSetting orderSetting);

	long findCountByOrderDate(Date orderDate);

	List<OrderSetting> getOrderSettingByMonth(Map<String, String> map);

}
