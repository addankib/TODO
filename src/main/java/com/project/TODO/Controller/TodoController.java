package com.project.TODO.Controller;



import com.project.TODO.Entity.TODO;
import com.project.TODO.Service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/TODO")


public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping()
    public ResponseEntity<List> get (){
        return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TODO> create(@RequestBody TODO todo){
            return new ResponseEntity<>(todoService.create(todo), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TODO> getSingle(@PathVariable("id") long id){
        return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

     @PutMapping("/{id}")
    public ResponseEntity<TODO> UpdateTodo(@PathVariable("id") long id, @RequestBody TODO todo){
      TODO todo1 =  todoService.UpdateTodo(id, todo);
      return new ResponseEntity<>(todo1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String DeleteTodo(@PathVariable("id") long id){
        return todoService.DeleteTodo(id);
    }
}
