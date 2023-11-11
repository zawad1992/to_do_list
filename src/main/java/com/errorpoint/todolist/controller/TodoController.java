package com.errorpoint.todolist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.errorpoint.todolist.dto.TodoDTO;
import com.errorpoint.todolist.entity.Todo;
import com.errorpoint.todolist.service.TodoService;

@RestController
@RequestMapping("api/v1")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @PostMapping("/todo-create")
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO) {
         return todoService.createTodo(todoDTO); 
    }

    @GetMapping("/todo-list")
    public List<Todo> todo() {
        return todoService.getAllTodos();
    }

    @GetMapping("/todo-list/{todoid}")
    public ResponseEntity<?> getTodoById(@PathVariable("todoid") Long todoid) {
        Optional<Todo> todoOptional = todoService.getTodoById(todoid);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            return ResponseEntity.ok(todo);
        } else {
            Map <String, String> response = new HashMap<>();
            response.put("message", "No data available");
            return ResponseEntity.ok(response);
        }
      
    }



    @PostMapping("/todo-update/{todoid}")
     public ResponseEntity<String> updateTodo(@PathVariable("todoid") Long todoid, @RequestBody TodoDTO todoDTO) {
        Optional <Todo> todoOptional = todoService.getTodoById(todoid);
        if(todoOptional.isPresent()) {
            try {
                todoService.updateTodo(todoid, todoDTO);
                return ResponseEntity.ok("Todo updated"); 
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating todo"+e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo ID not found");
        }
    }

    @DeleteMapping("/todo-delete/{todoid}")
    public ResponseEntity<String> deleteTodo(@PathVariable("todoid") Long todoid)  {
        Optional <Todo> todoOptional = todoService.getTodoById(todoid);
        if(todoOptional.isPresent()) {
            try {
                todoService.deleteById(todoid);
                return ResponseEntity.ok("Todo have been deleted");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting todo"+e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo ID not found");
        }
    }

    
}
