package com.hstn.crud.dao;

import com.hstn.crud.entity.Pupil;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PupilDAOImpl implements PupilDAO{

    private EntityManager entityManager;

    @Autowired
    public PupilDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Pupil pupil) {
        entityManager.persist(pupil);
    }

}
