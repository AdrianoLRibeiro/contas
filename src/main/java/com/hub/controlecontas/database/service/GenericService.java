package com.hub.controlecontas.database.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public class GenericService< E, K extends Serializable,  R  extends JpaRepository<E, K>> {

    R dao;

    public GenericService(R dao) {
        this.dao = dao;
    }

    public E save(E entity) {
        return (E) dao.save(entity);
    }

    public List<E> getAll() {
        return dao.findAll();
    }

    public E getById(K id) {
        return (E) dao.findOne((K) id);
    }

    public void delete(E entity) {
        dao.delete(entity);
    }

    public void delete(K id) {

        E entity = (E) dao.findOne((K) id);

        if (entity == null) return;

        dao.delete(entity);
    }

    public E update(E entity) {
        return (E) dao.save(entity);
    }
}
