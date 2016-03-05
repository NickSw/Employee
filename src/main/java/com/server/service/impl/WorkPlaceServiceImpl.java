package com.server.service.impl;
import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.service.WorkPlaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkPlaceServiceImpl implements WorkPlaceService {

    public WorkPlaceServiceImpl() {
        System.out.println("WorkPlaceServiceImpl()");
    }

    @Autowired
    private WorkPlaceDAO workPlaceDAO;

    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.createWorkPlace(workPlace);
    }
    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return workPlaceDAO.updateWorkPlace(workPlace);
    }
    @Override
    public void deleteWorkPlace(int id) {
        workPlaceDAO.deleteWorkPlace(id);
    }
    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return workPlaceDAO.getAllWorkPlaces();
    }
    @Override
    public WorkPlace getWorkPlace(int id) {
        return workPlaceDAO.getWorkPlace(id);
    }
}
