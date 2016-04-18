package com.server.service.impl;
import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.service.WorkPlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ���������� ���������� WorkPlaceService
 * ������:
 * ������� ���� ���� ������ �� �������
 * ������� ����� ������ �� ������� �� id
 * ������� ����� ������
 * �������� ����� ������
 * ������� ����� ������
 *
 * �������������� ��� ������ ���� DAO
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
     * ���������� ��� ���� ������
     * @return
     */
    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return workPlaceDAO.getAllWorkPlaces();
    }

    /**
     * ���������� ����� ������ �� id
     * @param id
     * @return
     */
    @Override
    public WorkPlace getWorkPlace(int id) {
        return workPlaceDAO.getWorkPlace(id);
    }

    /**
     * �������� ����� ������
     * @param workPlace
     * @return
     */
    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.createWorkPlace(workPlace);
    }

    /**
     * ��������� ����� ������
     * @param workPlace
     * @return
     */
    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.updateWorkPlace(workPlace);
    }

    /**
     * �������� ����� ������
     * @param id
     */
    @Override
    public void deleteWorkPlace(int id) {
        workPlaceDAO.deleteWorkPlace(id);
    }

}
