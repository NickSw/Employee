package com.server.service.impl;
import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.service.OrderTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса OrderTypeService
 * Методы:
 * Извлечь всех типов приказов из таблицы типов приказов
 * Извлечь тип приказа из таблицы по id
 * Создать тип приказа
 * Изменить тип приказа
 * Удалить тип приказа
 *
 * Осуществляется при помощи слоя DAO
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
     * Извлечь все типы приказов
     * @return
     */
    @Override
    public List<OrderType> getAllOrderTypes() {
        return orderTypeDAO.getAllOrderTypes();
    }

    /**
     * Извлечь тип приказа по id
     * @param id
     * @return
     */
    @Override
    public OrderType getOrderType(long id) {
        return orderTypeDAO.getOrderType(id);
    }

    /**
     * Создать тип приказа
     * @param orderType
     * @return
     */
    @Override
    public long createOrderType(OrderType orderType) {
        return orderTypeDAO.createOrderType(orderType);
    }

    /**
     * Изменить тип приказа
     * @param orderType
     * @return
     */
    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return orderTypeDAO.updateOrderType(orderType);
    }

    /**
     * Удалить тип приказа
     * @param id
     */
    @Override
    public void deleteOrderType(long id) {
        orderTypeDAO.deleteOrderType(id);
    }

}
