
package com.server.service;
import com.server.entity.WorkPlace;

import java.util.List;

public interface WorkPlaceService {
    public long createWorkPlace(WorkPlace workPlace);
    public WorkPlace updateWorkPlace(WorkPlace workPlace);
    public void deleteWorkPlace(int id);
    public List<WorkPlace> getAllWorkPlaces();
    public WorkPlace getWorkPlace(int id);
}
