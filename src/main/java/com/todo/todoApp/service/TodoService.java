package com.todo.todoApp.service;

import com.todo.todoApp.dto.TodoPatchDto;
import com.todo.todoApp.dto.TodoPostDto;
import com.todo.todoApp.dto.TodoResponseDto;
import com.todo.todoApp.dto.TodoResponseDtoList;
import com.todo.todoApp.entity.Todo;
import com.todo.todoApp.repository.TodoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto saveTodo(TodoPostDto todoPostDto) {
        Todo todo = Todo.of(todoPostDto);

        todoRepository.save(todo);

        return TodoResponseDto.of(todo);
    }

    public TodoResponseDto findTodo(Long id) {
        Todo findTodo = todoRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        return TodoResponseDto.of(findTodo);
    }

    public TodoResponseDtoList findTodoList() {
        return TodoResponseDtoList.of(todoRepository.findAll());
    }

    public TodoResponseDto updateTodo(TodoPatchDto todoPatchDto) {
        Todo updatetodo = todoRepository.findById(todoPatchDto.getId()).orElseThrow(IllegalArgumentException::new);

        updatetodo.update(todoPatchDto);

        return TodoResponseDto.of(updatetodo);
    }


    public void deleteAllTodo() {
        todoRepository.deleteAll();
    }


    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }


}
