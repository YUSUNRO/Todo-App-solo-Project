package com.todo.todoApp.dto;

import lombok.Getter;


@Getter
public class TodoPostDto {

    private String title;

    private int todoOrder;

    private boolean completed;

}
