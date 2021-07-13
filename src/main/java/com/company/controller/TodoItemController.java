package com.company.controller;

import com.company.model.TodoData;
import com.company.model.TodoItem;
import com.company.service.TodoItemService;
import com.company.service.TodoItemServiceImpl;
import com.company.util.AttributeNames;
import com.company.util.Mappings;
import com.company.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute("TodoData69")
    public TodoData todoData(){
        return todoItemService.getData();
    }



    // == handler method ==
    // http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMs)
    public String items(){
        return ViewNames.ITEMs_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id,
                              Model model){
        log.info("editing id ={}",id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("","", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("todoItem from form = {}",todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/"+ Mappings.ITEMs;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoItemService.removeItem(id);
        return "redirect:/"+ Mappings.ITEMs;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewITem(@RequestParam int id, Model model){
        // Model is used in jsp file !
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,todoItem);
        return ViewNames.VIEW_ITEM;
    }






}
