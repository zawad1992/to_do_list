package com.errorpoint.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.errorpoint.todolist.dto.TodoDTO;
import com.errorpoint.todolist.entity.Todo;
import com.errorpoint.todolist.repository.TodoRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public List<Todo> getCompletedTodos() {
        return todoRepository.findByStatus(true);
    }

    public TodoDTO createTodo(TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setStatus(todoDTO.getStatus());

        Todo savedTodo = todoRepository.save(todo);
        todoDTO.setId(savedTodo.getId());

        todoRepository.save(todo);
        return todoDTO;
    }

    

    public TodoDTO updateTodo(Long todoid, TodoDTO todoDTO) {
        Todo todo = new Todo();
        todo.setId(todoid);
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setStatus(todoDTO.getStatus());
        todoRepository.save(todo);
        System.out.println(todoid);

        return todoDTO;
    }

    public void deleteById(Long todoid) {
        todoRepository.deleteById(todoid);
    }
}
