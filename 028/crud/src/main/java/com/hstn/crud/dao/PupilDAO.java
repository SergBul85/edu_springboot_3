package com.hstn.crud.dao;

import com.hstn.crud.entity.Pupil;

import java.util.List;

public interface PupilDAO {

    void save(Pupil pupil);

    Pupil findById(int id);

    List<Pupil> findAll();
}
