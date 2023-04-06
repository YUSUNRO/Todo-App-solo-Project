package com.todo.todoApp.controller;

import com.todo.todoApp.dto.TodoPatchDto;
import com.todo.todoApp.dto.TodoPostDto;
import com.todo.todoApp.dto.TodoResponseDto;
import com.todo.todoApp.dto.TodoResponseDtoList;
import com.todo.todoApp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponseDto> postTodo(@RequestBody TodoPostDto todoPostDto) {

        TodoResponseDto todoResponseDto = todoService.saveTodo(todoPostDto);

        return ResponseEntity.ok(todoResponseDto);
    }

    @GetMapping
    public ResponseEntity<TodoResponseDtoList> getTodoList() {
        TodoResponseDtoList todoResponseDtoList = todoService.findTodoList();

        return ResponseEntity.ok(todoResponseDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> getTodo(@PathVariable("id") Long id) {

        TodoResponseDto todoResponseDto = todoService.findTodo(id);

        return ResponseEntity.ok(todoResponseDto);
    }

    @PatchMapping
    public ResponseEntity<TodoResponseDto> updateTodo(@RequestBody TodoPatchDto todoPatchDto) {

        TodoResponseDto todoResponseDto = todoService.updateTodo(todoPatchDto);

        return ResponseEntity.ok(todoResponseDto);
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        todoService.deleteAllTodo();

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);

        return ResponseEntity.ok(null);
    }





}
