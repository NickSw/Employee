package com.server.dao.impl;

import com.server.dao.WorkPlaceDAO;
import com.server.entity.WorkPlace;
import com.server.util.HibernateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkPlaceDAOImpl implements WorkPlaceDAO {

    public WorkPlaceDAOImpl() {
        System.out.println("WorkPlaceDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createWorkPlace(WorkPlace workPlace) {
        return (Long) hibernateUtil.create(workPlace);
    }

    @Override
    public WorkPlace updateWorkPlace(WorkPlace workPlace) {
        return hibernateUtil.update(workPlace);
    }

    @Override
    public void deleteWorkPlace(long id) {
        WorkPlace workPlace = new WorkPlace();
        workPlace.setId(id);
        hibernateUtil.delete(workPlace);
    }

    @Override
    public List<WorkPlace> getAllWorkPlaces() {
        return hibernateUtil.fetchAll(WorkPlace.class);
    }

    @Override
    public WorkPlace getWorkPlace(long id) {
        return hibernateUtil.fetchById(id, WorkPlace.class);
    }

}