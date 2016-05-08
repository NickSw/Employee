package com.server.service.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация интерфейса MovementService
 * Методы:
 * Извлечь всех приказов по сотруднику из таблицы приказов
 * Извлечь приказа из таблицы по id
 * Создать приказ
 * Изменить приказ
 * Удалить приказ
 * Переместить приказ в архив
 * Дублировать поле приказа
 *
 * Осуществляется при помощи слоя DAO
 */
@Service
@Transactional
public class MovementServiceImpl implements MovementService{

    public MovementServiceImpl(){
        System.out.println("MovementServiceImpl");
    }

    @Autowired
    private MovementDAO movementDAO;

    /**
     * Извлечение всех приказов по сотрудникам
     * @return
     */
    @Override
    public List<Movement> getAllMovements() {
        return movementDAO.getAllMovements();
    }

    /**
     * Извлечение приказа по сотруднику по id
     * @param id
     * @return
     */
    @Override
    public Movement getMovement(int id) {
        return movementDAO.getMovement(id);
    }

    /**
     * Создание приказа по сотруднику
     * @param movement
     * @return
     */
    @Override
    public long createMovement(Movement movement) {
        return movementDAO.createMovement(movement);
    }

    /**
     * Изменение приказа по сотруднику
     * @param movement
     * @return
     */
    @Override
    public Movement updateMovement(Movement movement) {
        return movementDAO.updateMovement(movement);
    }

    /**
     * Удаление приказа по сотруднику
     * @param id
     */
    @Override
    public void deleteMovement(int id) {
        movementDAO.deleteMovement(id);
    }

    /**
     * Перемещение приказа в архив
     * @param id
     */
    @Override
    public void moveToMovementArchive(int id) {movementDAO.moveToMovementArchive(id);}

    /**
     * Дублирование приказа
     * @param id
     */
    @Override
    public void copyMovement(int id){
        Movement movement = movementDAO.getMovement(id);
        Movement movementCopy = new Movement(movement);
        movementDAO.createMovement(movementCopy);
    }
}
