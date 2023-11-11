package com.errorpoint.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.errorpoint.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    List<Todo> findByStatus(boolean b);
    
}
