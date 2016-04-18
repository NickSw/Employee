package com.server.dao.impl;

import com.server.dao.MovementArchiveDAO;
import com.server.entity.MovementArchive;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ���������� ���������� MovementArchiveDAO
 * ������:
 * ������� ���� �������� �������� �� ����������� �� ������ �������� �� �����������
 * ������� �������� ������ �� ���������� �� ������ �������� �� �����������
 *
 * �������������� ��� ������ ���������������� ������ HibernateUtil
 */
@Repository
public class MovementArchiveDAOImpl implements MovementArchiveDAO {

    public MovementArchiveDAOImpl() {
        System.out.println("MovementArchiveDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * ���������� ���� �������� �������� �� �������
     * @return
     */
    @Override
    public List<MovementArchive> getAllMovementsArchive() {
        return hibernateUtil.fetchAll(MovementArchive.class);
    }

     /**
     * �������� ��������� ������� �� ����������
     * @param id
     */
    @Override
    public void deleteMovementArchive(long id) {
        MovementArchive movementArchive = new MovementArchive();
        movementArchive.setId(id);
        hibernateUtil.delete(movementArchive);
    }

}
