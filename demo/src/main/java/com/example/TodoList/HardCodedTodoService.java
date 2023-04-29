package com.example.TodoList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HardCodedTodoService {

    public static List<Todo> todos = new ArrayList<>();
    static int idCounter=0;
    static
    {
        todos.add(new Todo(++idCounter,"Learn to Dance","Madhu",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn to Sing","Nive",new Date(),false));
        todos.add(new Todo(++idCounter,"Learn to Draw","Shanthi",new Date(),false));
    }
    public List<Todo> getAlltodos()
    {
        return todos;
    }

    public Todo deleteById(long id)
    {
        Todo todo = findById(id);
        if(todo==null)
            return null;
        if(todos.remove(todo))
            return todo;
        return null;
    }
    public Todo save(Todo todo)
    {
        if(todo.getId()==-1)
        {
            todo.setId(++idCounter);
            todos.add(todo);
        }
        else
        {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo findById(long id)
    {
        for(Todo todo: todos)
        {
            if(todo.getId()==id)
                return todo;
        }
        return null;
    }
}
