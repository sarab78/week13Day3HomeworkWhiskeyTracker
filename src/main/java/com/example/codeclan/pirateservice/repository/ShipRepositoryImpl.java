package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Ship;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ShipRepositoryImpl implements ShipRepositoryCustom {

    @Autowired
    EntityManager entityManager; //It allows us to access the database.

    @Transactional
    public List<Ship> findShipsThatHavePiratesNamed(String firstName) {
        List<Ship> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Ship.class);
            cr.createAlias("pirates", "pirate");
            cr.add(Restrictions.eq("pirate.firstName", firstName));
            result = cr.list();
        } catch (HibernateException e ) {
            e.printStackTrace();
        }
        return result;
    }



}


//TODO: Put full methods for custom queries here.
