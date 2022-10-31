package com.example.daohibernate.repository;

import com.example.daohibernate.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<PersonEntity> getPersonsByCity(String city) {
        Query query = entityManager.createNativeQuery("select * from persons where city_of_living like :city")
                .setParameter("city", city);
        return query.getResultList();
    }
}
