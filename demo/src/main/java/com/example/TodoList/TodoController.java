package com.example.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
public class TodoController {

    @Autowired
    public HardCodedTodoService service;

    @Autowired
    public TodoRepository repository;

    @GetMapping(value="/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username)
    {
          return repository.findAll();
    }


    @GetMapping(value="/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable long id)
    {

        return repository.findById(id).get();
    }

    @DeleteMapping(value="/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable String username,@PathVariable long id)
    {
        //Todo todo = service.deleteById(id);
        repository.deleteById(id);
        //if(todo!=null)
        return ResponseEntity.noContent().build();
        //return ResponseEntity.notFound().build();
    }

    @PutMapping(value="/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todo todo)
    {
        //Todo updatedtodo = service.save(todo);
        Todo updatedtodo = repository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping(value="/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,@RequestBody Todo todo)
    {
        //Todo createdtodo = service.save(todo);
        todo.setUsername(username);
        Todo createdtodo = repository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdtodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
