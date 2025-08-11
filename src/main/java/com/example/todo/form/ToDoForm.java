package com.example.todo.form;

import lombok.Data;

@Data
public class ToDoForm {
  
  private Integer id;
  private String todo;
  private String detail;
  private Boolean isNew;
 
}
