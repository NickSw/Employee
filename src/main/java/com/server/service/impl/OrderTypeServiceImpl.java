package com.server.service.impl;
import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.service.OrderTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderTypeServiceImpl implements OrderTypeService {

    public OrderTypeServiceImpl() {
        System.out.println("OrderTypeServiceImpl()");
    }

    @Autowired
    private OrderTypeDAO orderTypeDAO;

    @Override
    public long createOrderType(OrderType orderType) {
        return orderTypeDAO.createOrderType(orderType);
    }
    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return orderTypeDAO.updateOrderType(orderType);
    }
    @Override
    public void deleteOrderType(long id) {
        orderTypeDAO.deleteOrderType(id);
    }
    @Override
    public List<OrderType> getAllOrderTypes() {
        return orderTypeDAO.getAllOrderTypes();
    }
    @Override
    public OrderType getOrderType(long id) {
        return orderTypeDAO.getOrderType(id);
    }
    @Override
    public List<OrderType> getAllOrderTypes(String ordertype) {
        return orderTypeDAO.getAllOrderTypes(ordertype);
    }
}
