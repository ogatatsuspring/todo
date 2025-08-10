package com.example.todo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.todo.entity.ToDo;

@Mapper
public interface ToDoMapper {
  
  List<ToDo> selectAll();
  ToDo selectById( @Param( "id" ) Integer id );
  int insert( ToDo todo );
  int update( ToDo todo );
  int delete( @Param( "id" ) Integer id );
  
}
