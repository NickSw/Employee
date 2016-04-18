package com.server.dao.impl;

import com.server.dao.OrderTypeDAO;
import com.server.entity.OrderType;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса OrderTypeDAO
 * Методы:
 * Извлечь всех типов приказов из таблицы типов приказов
 * Извлечь тип приказа из таблицы по id
 * Создать тип приказа
 * Изменить тип приказа
 * Удалить тип приказа
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class OrderTypeDAOImpl implements OrderTypeDAO {

    public OrderTypeDAOImpl() {
        System.out.println("OrderTypeDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * Извлечь все типы приказов из таблицы
     * @return
     */
    @Override
    public List<OrderType> getAllOrderTypes() {
        return hibernateUtil.fetchAll(OrderType.class);
    }

    /**
     * Извлечь тип приказа по id
     * @param id
     * @return
     */
    @Override
    public OrderType getOrderType(long id) {
        return hibernateUtil.fetchById(id, OrderType.class);
    }

    /**
     * Создать тип приказа
     * @param orderType
     * @return
     */
    @Override
    public long createOrderType(OrderType orderType) {
        return (Long) hibernateUtil.create(orderType);
    }

    /**
     * Обновить тип приказа
     * @param orderType
     * @return
     */
    @Override
    public OrderType updateOrderType(OrderType orderType) {
        return hibernateUtil.update(orderType);
    }

    /**
     * Удалить тип приказа
     * @param id
     */
    @Override
    public void deleteOrderType(long id) {
        OrderType orderType = new OrderType();
        orderType.setId(id);
        hibernateUtil.delete(orderType);
    }

}

