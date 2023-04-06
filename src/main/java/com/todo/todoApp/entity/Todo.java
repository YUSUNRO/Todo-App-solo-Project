package com.todo.todoApp.entity;

import com.todo.todoApp.dto.TodoPatchDto;
import com.todo.todoApp.dto.TodoPostDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int todoOrder;

    @Column(nullable = false)
    private boolean completed;


//    //생성자 막기위해
//    private Todo() {
//    }

    public static Todo of(TodoPostDto todoPostDto) {
        Todo todo = new Todo();

        todo.setTitle(todoPostDto.getTitle());
        todo.setTodoOrder(todoPostDto.getTodoOrder());
        todo.setCompleted(todoPostDto.isCompleted());

        return todo;
    }

    public void update(TodoPatchDto todoPatchDto) {
        if(todoPatchDto.getTitle() != null) {
            this.title = todoPatchDto.getTitle();
        }

        if(todoPatchDto.getTodoOrder() != 0) {
            this.todoOrder = todoPatchDto.getTodoOrder();
        }

        if(todoPatchDto.isCompleted() != this.completed) {
            this.completed = todoPatchDto.isCompleted();
        }
    }
}
