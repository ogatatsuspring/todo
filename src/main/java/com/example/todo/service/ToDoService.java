package com.example.todo.service;

import java.util.List;

import com.example.todo.entity.ToDo;

public interface ToDoService {
  
  List<ToDo> findAllToDo();
  ToDo findByIdToDo( Integer id );
  boolean insertToDo( ToDo todo );
  boolean updateToDo( ToDo todo );
  boolean deleteToDo( Integer id );
  
}
