package com.server.dao.impl;

import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ���������� ���������� WorkPlaceDAO
 * ������:
 * ������� ���� ���� ������ �� �������
 * ������� ����� ������ �� ������� �� id
 * ������� ����� ������
 * �������� ����� ������
 * ������� ����� ������
 *
 * �������������� ��� ������ ���������������� ������ HibernateUtil
 */
@Repository
public class WorkPlaceDAOImpl implements WorkPlaceDAO {

    public WorkPlaceDAOImpl() {
        System.out.println("WorkPlaceDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    /**
     * ������� ��� ����� ������ �� �������
     * @return
     */
    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return hibernateUtil.fetchAll(WorkPlace.class);
    }

    /**
     * ������� ����� ������ �� id
     * @param id
     * @return
     */
    @Override
    public WorkPlace getWorkPlace(long id) {
        return hibernateUtil.fetchById(id, WorkPlace.class);
    }

    /**
     * ������� ����� ������
     * @param workPlace
     * @return
     */
    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return (Long) hibernateUtil.create(workPlace);
    }

    /**
     * �������� ����� ������
     * @param workPlace
     * @return
     */
    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return hibernateUtil.update(workPlace);
    }

    /**
     * ������� ����� ������
     * @param id
     */
    @Override
    public void deleteWorkPlace(long id) {
        WorkPlace workPlace = new WorkPlace();
        workPlace.setId(id);
        hibernateUtil.delete(workPlace);
    }



}