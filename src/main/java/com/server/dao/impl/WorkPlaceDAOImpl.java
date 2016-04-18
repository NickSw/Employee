package com.server.dao.impl;

import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Реализация интерфейса WorkPlaceDAO
 * Методы:
 * Извлечь всех мест работы из таблицы
 * Извлечь место работы из таблицы по id
 * Создать место работы
 * Изменить место работы
 * Удалить место работы
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class WorkPlaceDAOImpl implements WorkPlaceDAO {

    public WorkPlaceDAOImpl() {
        System.out.println("WorkPlaceDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * Извлечь все места работы из таблицы
     * @return
     */
    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return hibernateUtil.fetchAll(WorkPlace.class);
    }

    /**
     * Извлечь место работы по id
     * @param id
     * @return
     */
    @Override
    public WorkPlace getWorkPlace(long id) {
        return hibernateUtil.fetchById(id, WorkPlace.class);
    }

    /**
     * Создать место работы
     * @param workPlace
     * @return
     */
    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return (Long) hibernateUtil.create(workPlace);
    }

    /**
     * Обновить место работы
     * @param workPlace
     * @return
     */
    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return hibernateUtil.update(workPlace);
    }

    /**
     * Удалить место работы
     * @param id
     */
    @Override
    public void deleteWorkPlace(long id) {
        WorkPlace workPlace = new WorkPlace();
        workPlace.setId(id);
        hibernateUtil.delete(workPlace);
    }



}