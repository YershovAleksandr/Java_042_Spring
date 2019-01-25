package com.nam.spring_42.board.dao;

import java.util.List;
import java.util.Optional;

public interface IDAO <T>{
    public List<T> getAll();
    public Optional<T> get(int id);
    public void update(T entity);
    public void create(T entity);
    public void delete(T entity);
}
