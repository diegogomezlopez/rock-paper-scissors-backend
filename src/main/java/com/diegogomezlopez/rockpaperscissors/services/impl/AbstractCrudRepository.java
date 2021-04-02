package com.diegogomezlopez.rockpaperscissors.services.impl;

public class AbstractCrudRepository<T> {

    private T entity;

    public T save(T entity) {
        this.entity = entity;
        return this.entity;
    }

    public T find() {
        return this.entity;
    }
}
