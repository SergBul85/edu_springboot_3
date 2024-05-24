package com.hstn.crud.dao;

import com.hstn.crud.entity.Pupil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PupilDAOImpl implements PupilDAO {

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

    @Override
    public Pupil findById(int id) {
        return entityManager.find(Pupil.class, id);
    }

    @Override
    public List<Pupil> findAll() {
        List<Pupil> pupils = entityManager.createQuery("from Pupil", Pupil.class).getResultList();
        return pupils;
    }

}
