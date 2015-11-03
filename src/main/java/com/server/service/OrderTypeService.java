package com.server.service;

import com.server.entity.OrderType;

import java.util.List;

public interface OrderTypeService {
    public long createOrderType(OrderType orderType);
    public OrderType updateOrderType(OrderType orderType);
    public void deleteOrderType(long id);
    public List<OrderType> getAllOrderTypes();
    public OrderType getOrderType(long id);
    public List<OrderType> getAllOrderTypes(String ordertype);
}
