package com.server.dao.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация интерфейса MovementDAO
 * Методы:
 * Извлечь всех приказов по сотруднику из таблицы приказов
 * Извлечь приказа из таблицы по id
 * Создать приказ
 * Изменить приказ
 * Удалить приказ
 * Переместить приказ в архив
 *
 * Осуществляется при помощи вспомогательного класса HibernateUtil
 */
@Repository
public class MovementDAOImpl implements MovementDAO {

    public MovementDAOImpl() {
        System.out.println("MovementDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * Извлечь все приказы
     * @return
     */
    @Override
    public List<Movement> getAllMovements() {
        return hibernateUtil.fetchAll(Movement.class);
    }

    /**
     * Извлечь приаказ по id
     * @param id
     * @return
     */
    @Override
    public Movement getMovement(long id) {
        return hibernateUtil.fetchById(id, Movement.class);
    }

    /**
     * Создать приказ
     * @param movement
     * @return
     */
    @Override
    public long createMovement(Movement movement) {
        return (Long) hibernateUtil.create(movement);
    }

    /**
     * Обновить приказ
     * @param movement
     * @return
     */
    @Override
    public Movement updateMovement(Movement movement) {
        return hibernateUtil.update(movement);
    }

    /**
     * Удалить приказ
     * @param id
     */
    @Override
    public void deleteMovement(long id) {
        Movement movement = new Movement();
        movement.setId(id);
        hibernateUtil.delete(movement);
    }

    /**
     * Переместить запись сотрудника в таблицу архив сотрудников
     * TODO: сделать запрос языком hql, помещать в метод только сущность
     * @param id
     */
    @Override
    public void moveToMovementArchive(long id) {
        Movement movement = new Movement();
        movement.setId(id);
        String query = "INSERT INTO mov_archive SELECT m.* FROM Movements m WHERE m.id =" + id + "";
        hibernateUtil.move(query, movement);
    }


}
