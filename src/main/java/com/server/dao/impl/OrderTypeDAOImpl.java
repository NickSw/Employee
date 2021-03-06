package com.server.dao.impl;

import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������� ���������� OrderTypeDAO
 * ������:
 * ������� ���� ����� �������� �� ������� ����� ��������
 * ������� ��� ������� �� ������� �� id
 * ������� ��� �������
 * �������� ��� �������
 * ������� ��� �������
 *
 * �������������� ��� ������ ���������������� ������ HibernateUtil
 */
@Repository
public class OrderTypeDAOImpl implements OrderTypeDAO {

    public OrderTypeDAOImpl() {
        System.out.println("OrderTypeDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * ������� ��� ���� �������� �� �������
     * @return
     */
    @Override
    public List<OrderType> getAllOrderTypes() {
        return hibernateUtil.fetchAll(OrderType.class);
    }

    /**
     * ������� ��� ������� �� id
     * @param id
     * @return
     */
    @Override
    public OrderType getOrderType(long id) {
        return hibernateUtil.fetchById(id, OrderType.class);
    }

    /**
     * ������� ��� �������
     * @param orderType
     * @return
     */
    @Override
    public long createOrderType(OrderType orderType) {
        return (Long) hibernateUtil.create(orderType);
    }

    /**
     * �������� ��� �������
     * @param orderType
     * @return
     */
    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return hibernateUtil.update(orderType);
    }

    /**
     * ������� ��� �������
     * @param id
     */
    @Override
    public void deleteOrderType(long id) {
        OrderType orderType = new OrderType();
        orderType.setId(id);
        hibernateUtil.delete(orderType);
    }

}

