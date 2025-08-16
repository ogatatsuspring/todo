package com.example.todo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.todo.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
  Authentication selectByUsername( String username );
}
