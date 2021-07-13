package com.company.service;

import com.company.model.TodoData;
import com.company.model.TodoItem;

import java.util.List;

public interface TodoItemService {
    void addItem(TodoItem todoItem);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem todoItem);
    TodoData getData();
}
