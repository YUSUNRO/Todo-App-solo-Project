package com.todo.todoApp.dto;


import lombok.Getter;


@Getter
public class TodoPatchDto {

    private Long Id;

    private String title;

    private int todoOrder;

    private boolean completed;


}
