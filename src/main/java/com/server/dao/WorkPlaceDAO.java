package com.server.dao;

import com.server.entity.WorkPlace;

import java.util.List;

public interface WorkPlaceDAO {
    public long createWorkPlace(WorkPlace workPlace);
    public WorkPlace updateWorkPlace(WorkPlace workPlace);
    public void deleteWorkPlace(long id);
    public List<WorkPlace> getAllWorkPlaces();
    public WorkPlace getWorkPlace(long id);
}
