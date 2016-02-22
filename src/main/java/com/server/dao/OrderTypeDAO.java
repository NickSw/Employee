package com.server.dao;

import com.server.entity.OrderType;

import java.util.List;

public interface OrderTypeDAO {
    public long createOrderType(OrderType orderType);
    public OrderType updateOrderType(OrderType orderType);
    public void deleteOrderType(long id);
    public List<OrderType> getAllOrderTypes();
    public OrderType getOrderType(long id);
}
