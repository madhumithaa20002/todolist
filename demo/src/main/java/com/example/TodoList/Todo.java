package com.example.TodoList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

import java.util.Date;
import java.util.Objects;


@Entity
public class Todo {

    @Id
    @GeneratedValue
    public long id;
    public String description;
    public String username;
    public Date targetDate;
    public boolean isDone;

    protected Todo()
    {

    }

    public Todo(long id,String description,String username,Date targetDate,boolean isDone) {
        this.id = id;
        this.description=description;
        this.username=username;
        this.targetDate=targetDate;
        this.isDone=isDone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id && isDone == todo.isDone && Objects.equals(description, todo.description) && Objects.equals(username, todo.username) && Objects.equals(targetDate, todo.targetDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, username, targetDate, isDone);
    }
}
