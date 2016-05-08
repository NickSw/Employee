package com.server.service.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ���������� ���������� MovementService
 * ������:
 * ������� ���� �������� �� ���������� �� ������� ��������
 * ������� ������� �� ������� �� id
 * ������� ������
 * �������� ������
 * ������� ������
 * ����������� ������ � �����
 * ����������� ���� �������
 *
 * �������������� ��� ������ ���� DAO
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
     * ���������� ���� �������� �� �����������
     * @return
     */
    @Override
    public List<Movement> getAllMovements() {
        return movementDAO.getAllMovements();
    }

    /**
     * ���������� ������� �� ���������� �� id
     * @param id
     * @return
     */
    @Override
    public Movement getMovement(int id) {
        return movementDAO.getMovement(id);
    }

    /**
     * �������� ������� �� ����������
     * @param movement
     * @return
     */
    @Override
    public long createMovement(Movement movement) {
        return movementDAO.createMovement(movement);
    }

    /**
     * ��������� ������� �� ����������
     * @param movement
     * @return
     */
    @Override
    public Movement updateMovement(Movement movement) {
        return movementDAO.updateMovement(movement);
    }

    /**
     * �������� ������� �� ����������
     * @param id
     */
    @Override
    public void deleteMovement(int id) {
        movementDAO.deleteMovement(id);
    }

    /**
     * ����������� ������� � �����
     * @param id
     */
    @Override
    public void moveToMovementArchive(int id) {movementDAO.moveToMovementArchive(id);}

    /**
     * ������������ �������
     * @param id
     */
    @Override
    public void copyMovement(int id){
        Movement movement = movementDAO.getMovement(id);
        Movement movementCopy = new Movement(movement);
        movementDAO.createMovement(movementCopy);
    }
}
