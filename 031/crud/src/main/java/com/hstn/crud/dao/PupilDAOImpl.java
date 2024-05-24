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

    @Override
    public List<Pupil> findPupilByLastName(String lastName) {
        TypedQuery<Pupil> query = entityManager.createQuery("from Pupil where lastName=:searchLastName", Pupil.class);
        query.setParameter("searchLastName", lastName);
        List<Pupil> pupils = query.getResultList();
        return pupils;
    }

    @Override
    @Transactional
    public void update(Pupil pupil) {
        entityManager.merge(pupil);
    }

    @Override
    @Transactional
    public void delete(int id) { //5

        Pupil pupil = entityManager.find(Pupil.class, id); // = null

        if (pupil != null) {
            entityManager.remove(pupil);
            System.out.println("Delete success!");
        } else {
            System.out.println("No pupil with id=" + id + " in DB!");
        }
    }

    @Override
    @Transactional
    public int deleteAllPupils() {
        int quantityOfDeletedPupils = entityManager.createQuery("delete from Pupil").executeUpdate();
        return quantityOfDeletedPupils;
    }
}
