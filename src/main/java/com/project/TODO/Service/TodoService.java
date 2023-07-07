package com.project.TODO.Service;

import com.project.TODO.DAO.TodoRepository;
import com.project.TODO.Entity.TODO;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class TodoService{

    @Autowired
    TodoRepository todoRepository;


    public List<TODO> getAll(){
        return todoRepository.findAll();
    }


    public TODO getTodoById(Long id){
        TODO todo= todoRepository.findById(id).orElseThrow(()->new RuntimeException("TODO not found by ID"));
        return todo;
    }

    public TODO create (TODO todo){
      todoRepository.save(todo);
      return todo;
    }

    public TODO UpdateTodo(Long id, TODO todo){
        TODO todo1= todoRepository.findById(id).orElseThrow(()->new RuntimeException("TODO not found by ID"));
        todo1.setTodo(todo.getTodo());
        todo1.setDescription(todo.getDescription());
        todo1.setCompleted(todo.getCompleted());
        todoRepository.save(todo1);
        return todo1;
    }

    public String DeleteTodo(Long id){
        todoRepository.deleteById(id);
        return "Todo was deleted";


    }

}
