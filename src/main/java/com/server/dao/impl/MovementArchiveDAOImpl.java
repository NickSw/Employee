package com.server.dao.impl;

import com.server.dao.MovementArchiveDAO;
import com.server.entity.MovementArchive;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovementArchiveDAOImpl implements MovementArchiveDAO {

    public MovementArchiveDAOImpl() {
        System.out.println("MovementArchiveDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createMovementArchive(MovementArchive movementArchive) {
        return (Long) hibernateUtil.create(movementArchive);
    }

    @Override
    public MovementArchive updateMovementArchive(MovementArchive movementArchive) {
        return hibernateUtil.update(movementArchive);
    }

    @Override
    public void deleteMovementArchive(long id) {
        MovementArchive movementArchive = new MovementArchive();
        movementArchive.setId(id);
        hibernateUtil.delete(movementArchive);
    }

    @Override
    public List<MovementArchive> getAllMovementsArchive() {
        return hibernateUtil.fetchAll(MovementArchive.class);
    }

    @Override
    public MovementArchive getMovementArchive(long id) {
        return hibernateUtil.fetchById(id, MovementArchive.class);
    }

}
