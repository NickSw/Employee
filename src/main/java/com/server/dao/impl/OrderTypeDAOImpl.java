package com.server.dao.impl;

import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderTypeDAOImpl implements OrderTypeDAO {

    public OrderTypeDAOImpl() {
        System.out.println("OrderTypeDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createOrderType(OrderType orderType) {
        return (Long) hibernateUtil.create(orderType);
    }

    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return hibernateUtil.update(orderType);
    }

    @Override
    public void deleteOrderType(long id) {
        OrderType orderType = new OrderType();
        orderType.setId(id);
        hibernateUtil.delete(orderType);
    }

    @Override
    public List<OrderType> getAllOrderTypes() {
        return hibernateUtil.fetchAll(OrderType.class);
    }

    @Override
    public OrderType getOrderType(long id) {
        return hibernateUtil.fetchById(id, OrderType.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderType> getAllOrderTypes(String ordertype) {
        String query = "SELECT m.* FROM OrderTypes m WHERE m.ordertype like '%" + ordertype +"%'";
        List<Object[]> orderTypeObjects = hibernateUtil.fetchAll(query);
        List<OrderType> orderTypes = new ArrayList<OrderType>();
        for(Object[] orderTypeObject: orderTypeObjects){
            OrderType orderType = new OrderType();
            int id = (int) orderTypeObject[0];
            String orderstype = (String) orderTypeObject[1];
            String notes = (String) orderTypeObject[2];

            orderType.setId(id);
            orderType.setOrdertype(orderstype);
            orderType.setNotes(notes);

            orderTypes.add(orderType);
        }
        return orderTypes;
    }
}

