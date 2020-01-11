package com.example.demo.process;

import com.example.demo.controll.OrderCheck;
import com.example.demo.database.UserOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class OrdersH2Impl implements H2Impl {

    private static final Logger logger = LoggerFactory.getLogger(UserOrder.class);
    OrderCheck orderCheck;


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserOrder getOrder(int id) {

        try {
            return (UserOrder) entityManager
                    .createQuery("SELECT UserOrder FROM UserOrder AS UserOrder WHERE UserOrder.id=: id")
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (NoResultException e) {
            System.err.println("Error during creating querry for getOrder! ");
            logger.info("No result exception.");
            throw e;
        }
    }

    @Override
    public void saveOrder(UserOrder uO) {
        entityManager.persist(uO);
        UserOrder e1 = (UserOrder) entityManager
                .createQuery("SELECT UserOrder FROM UserOrder AS UserOrder WHERE UserOrder.id=:id")
                .setParameter("id", uO.getId())
                .getSingleResult();
    }

    @Override
    public boolean removeOrder(int id) {
        entityManager
                .createQuery("DELETE FROM UserOrder WHERE id=: id")
                .setParameter("id", id)
                .executeUpdate();
        return true;
    }


}