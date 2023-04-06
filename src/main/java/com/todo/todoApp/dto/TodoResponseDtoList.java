package com.todo.todoApp.dto;

import com.todo.todoApp.entity.Todo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoResponseDtoList {
    private List<TodoResponseDto> todoResponseDtoList;


    public static TodoResponseDtoList of(List<Todo> all) {
        TodoResponseDtoList responseDtoList = new TodoResponseDtoList();
        List<TodoResponseDto> todoResponseDtos = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            TodoResponseDto todoResponseDto = TodoResponseDto.of(all.get(i));
            todoResponseDtos.add(todoResponseDto);
        }

        responseDtoList.setTodoResponseDtoList(todoResponseDtos);

        return responseDtoList;
    }
}
