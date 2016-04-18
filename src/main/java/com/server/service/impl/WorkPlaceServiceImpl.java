package com.server.service.impl;
import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.service.WorkPlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса WorkPlaceService
 * Методы:
 * Извлечь всех мест работы из таблицы
 * Извлечь место работы из таблицы по id
 * Создать место работы
 * Изменить место работы
 * Удалить место работы
 *
 * Осуществляется при помощи слоя DAO
 */
@Service
@Transactional
public class WorkPlaceServiceImpl implements WorkPlaceService {

    public WorkPlaceServiceImpl() {
        System.out.println("WorkPlaceServiceImpl()");
    }

    @Autowired
    private WorkPlaceDAO workPlaceDAO;

    /**
     * Извлечение все мест работы
     * @return
     */
    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return workPlaceDAO.getAllWorkPlaces();
    }

    /**
     * Извлечение места работы по id
     * @param id
     * @return
     */
    @Override
    public WorkPlace getWorkPlace(int id) {
        return workPlaceDAO.getWorkPlace(id);
    }

    /**
     * Создание места работы
     * @param workPlace
     * @return
     */
    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.createWorkPlace(workPlace);
    }

    /**
     * Изменение места работы
     * @param workPlace
     * @return
     */
    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.updateWorkPlace(workPlace);
    }

    /**
     * Удаление места работы
     * @param id
     */
    @Override
    public void deleteWorkPlace(int id) {
        workPlaceDAO.deleteWorkPlace(id);
    }

}
