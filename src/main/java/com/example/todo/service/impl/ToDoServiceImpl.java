package com.example.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoMapper;
import com.example.todo.service.ToDoService;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {
  
  private final ToDoMapper toDoMapper;
  
  public ToDoServiceImpl( ToDoMapper toDoMapper ) {
    this.toDoMapper = toDoMapper;
  }
  
  @Override
  public List<ToDo> findAllToDo() {
    return toDoMapper.selectAll();
  }
  
  @Override
  public ToDo findByIdToDo( Integer id ) {
    return toDoMapper.selectById( id );
  }
  
  @Override
  public boolean insertToDo( ToDo toDo ) {
    if ( toDoMapper.insert( toDo ) == 1 ) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public boolean updateToDo( ToDo toDo ) {
    if ( toDoMapper.update( toDo ) == 1 ) {
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public boolean deleteToDo( Integer id ) {
    if ( toDoMapper.delete( id ) == 1 ) {
      return true;
    } else {
      return false;
    }
  }

}
