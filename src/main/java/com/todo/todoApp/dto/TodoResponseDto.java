package com.todo.todoApp.dto;


import com.todo.todoApp.entity.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoResponseDto {

    private Long Id;

    private String title;

    private int todoOrder;

    private boolean completed;

    public static TodoResponseDto of(Todo todo) {
        TodoResponseDto todoResponseDto = new TodoResponseDto();

        todoResponseDto.setId(todo.getId());
        todoResponseDto.setTitle(todo.getTitle());
        todoResponseDto.setTodoOrder(todo.getTodoOrder());
        todoResponseDto.setCompleted(todo.isCompleted());

        return todoResponseDto;
    }
}
