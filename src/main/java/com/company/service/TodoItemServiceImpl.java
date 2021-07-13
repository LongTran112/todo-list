package com.company.service;

import com.company.model.TodoData;
import com.company.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    @Getter
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

}