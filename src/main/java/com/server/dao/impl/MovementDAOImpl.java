package com.server.dao.impl;

import com.server.dao.MovementDAO;
import com.server.entity.Movement;
import com.server.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovementDAOImpl implements MovementDAO {

    public MovementDAOImpl() {
        System.out.println("MovementDAOImpl");
    }

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public long createMovement(Movement movement) {
        return (Long) hibernateUtil.create(movement);
    }

    @Override
    public Movement updateMovement(Movement movement) {
        return hibernateUtil.update(movement);
    }

    @Override
    public void deleteMovement(long id) {
        Movement movement = new Movement();
        movement.setId(id);
        hibernateUtil.delete(movement);
    }

    @Override
    public List<Movement> getAllMovements() {
        return hibernateUtil.fetchAll(Movement.class);
    }

    @Override
    public Movement getMovement(long id) {
        return hibernateUtil.fetchById(id, Movement.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Movement> getAllMovements(String orderNumber) {
        String query = "SELECT m.* FROM Movements m WHERE m.ordernum like '%" + orderNumber +"%'";
        List<Object[]> movementObjects = hibernateUtil.fetchAll(query);
        List<Movement> movements = new ArrayList<Movement>();
        for(Object[] movementObject: movementObjects){
            Movement movement = new Movement();
            int id = (int) movementObject[0];
            java.sql.Date orderdate = (java.sql.Date) movementObject[1];
            String ordernum = (String) movementObject[2];
            String ordertype = (String) movementObject[3];
            String fio = (String) movementObject[4];
            String ordertext = (String) movementObject[5];

            movement.setId(id);
            movement.setOrderdate(orderdate);
            movement.setOrdernum(ordernum);
            movement.setOrdertype(ordertype);
            movement.setFio(fio);
            movement.setOrdertext(ordertext);

            movements.add(movement);
        }
        return movements;
    }
}
