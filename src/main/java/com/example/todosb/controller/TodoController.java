package com.example.todosb.controller;

import com.example.todosb.exception.ResourceNotFoundException;
import com.example.todosb.model.TodoItem;
import com.example.todosb.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/v1")
public class TodoController {

    private TodoItemRepository todoItemRepository;

    @Autowired
    public void setTodoItemRepository(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping("todoItems")
    public List<TodoItem> getTodoItemList() {
        return todoItemRepository.findAll();
    }

    @PostMapping("todoItem")
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    @GetMapping("/todoItem/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable  Long id) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todoitem not found with id ="+id));
        return ResponseEntity.ok(todoItem);
    }

    @PutMapping("/todoItem/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        todoItemRepository.save()
    }
}
