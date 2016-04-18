package com.server.service.impl;
import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.service.OrderTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ���������� ���������� OrderTypeService
 * ������:
 * ������� ���� ����� �������� �� ������� ����� ��������
 * ������� ��� ������� �� ������� �� id
 * ������� ��� �������
 * �������� ��� �������
 * ������� ��� �������
 *
 * �������������� ��� ������ ���� DAO
 */
@Service
@Transactional
public class OrderTypeServiceImpl implements OrderTypeService {

    public OrderTypeServiceImpl() {
        System.out.println("OrderTypeServiceImpl()");
    }

    @Autowired
    private OrderTypeDAO orderTypeDAO;

    /**
     * ������� ��� ���� ��������
     * @return
     */
    @Override
    public List<OrderType> getAllOrderTypes() {
        return orderTypeDAO.getAllOrderTypes();
    }

    /**
     * ������� ��� ������� �� id
     * @param id
     * @return
     */
    @Override
    public OrderType getOrderType(long id) {
        return orderTypeDAO.getOrderType(id);
    }

    /**
     * ������� ��� �������
     * @param orderType
     * @return
     */
    @Override
    public long createOrderType(OrderType orderType) {
        return orderTypeDAO.createOrderType(orderType);
    }

    /**
     * �������� ��� �������
     * @param orderType
     * @return
     */
    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return orderTypeDAO.updateOrderType(orderType);
    }

    /**
     * ������� ��� �������
     * @param id
     */
    @Override
    public void deleteOrderType(long id) {
        orderTypeDAO.deleteOrderType(id);
    }

}
