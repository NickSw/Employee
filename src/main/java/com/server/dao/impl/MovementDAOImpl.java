package com.server.dao.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������� ���������� MovementDAO
 * ������:
 * ������� ���� �������� �� ���������� �� ������� ��������
 * ������� ������� �� ������� �� id
 * ������� ������
 * �������� ������
 * ������� ������
 * ����������� ������ � �����
 *
 * �������������� ��� ������ ���������������� ������ HibernateUtil
 */
@Repository
public class MovementDAOImpl implements MovementDAO {

    public MovementDAOImpl() {
        System.out.println("MovementDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * ������� ��� �������
     * @return
     */
    @Override
    public List<Movement> getAllMovements() {
        return hibernateUtil.fetchAll(Movement.class);
    }

    /**
     * ������� ������� �� id
     * @param id
     * @return
     */
    @Override
    public Movement getMovement(long id) {
        return hibernateUtil.fetchById(id, Movement.class);
    }

    /**
     * ������� ������
     * @param movement
     * @return
     */
    @Override
    public long createMovement(Movement movement) {
        return (Long) hibernateUtil.create(movement);
    }

    /**
     * �������� ������
     * @param movement
     * @return
     */
    @Override
    public Movement updateMovement(Movement movement) {
        return hibernateUtil.update(movement);
    }

    /**
     * ������� ������
     * @param id
     */
    @Override
    public void deleteMovement(long id) {
        Movement movement = new Movement();
        movement.setId(id);
        hibernateUtil.delete(movement);
    }

    /**
     * ����������� ������ ���������� � ������� ����� �����������
     * TODO: ������� ������ ������ hql, �������� � ����� ������ ��������
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
