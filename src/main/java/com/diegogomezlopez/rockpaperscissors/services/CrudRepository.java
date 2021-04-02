package com.diegogomezlopez.rockpaperscissors.services;

import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository<T> {

    T save(T entity);
    T find();
}
