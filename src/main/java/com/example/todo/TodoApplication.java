package com.example.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.todo.entity.ToDo;
import com.example.todo.repository.ToDoMapper;
import com.example.todo.service.ToDoService;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	private final ToDoMapper mapper;
	private final ToDoService service;
	
	public TodoApplication( ToDoMapper mapper, ToDoService service ) {
	  this.mapper = mapper;
	  this.service = service;
	}
	
	@Override
	public void run( String... args ) throws Exception {
	  
	  System.out.println( "====全件検索====" );
//	  for ( ToDo row: mapper.selectAll() ) {
	  for ( ToDo row: service.findAllToDo() ) {
	    System.out.println( row );
	  }
	  
	  System.out.println( "====1件検索====" );
//	  System.out.println( mapper.selectById( 1 ) );
	  System.out.println( service.findByIdToDo( 1 ) );
	  
	  ToDo todo = new ToDo();
	  todo.setTodo( "リポジトリのテスト" );
	  todo.setDetail( "DBへの登録処理" );
//	  if ( mapper.insert( todo ) == 1 ) {
	  if ( service.insertToDo( todo ) ) {
	    System.out.println( "====登録成功====" );
//	    System.out.println( mapper.selectById( 4 ) );
	    System.out.println( service.findByIdToDo( 4 ) );
	  } else {
	    System.out.println( "====登録失敗====" );
	  }
	  
//	  ToDo target = mapper.selectById( 4 );
	  ToDo target = service.findByIdToDo( 4 );
	  target.setTodo( "リポジトリのテスト：更新" );
	  target.setDetail( "DBへの更新処理" );
//	  if ( mapper.update( target ) == 1 ) {
	  if ( service.updateToDo( target ) ) {
	    System.out.println( "====更新成功====" );
//	    System.out.println( mapper.selectById( 4 ) );
	    System.out.println( service.findByIdToDo( 4 ) );
	  } else {
	    System.out.println( "====更新失敗====" );
	  }
	  
//	  if ( mapper.delete( 4 ) == 1 ) {
	  if ( service.deleteToDo( 4 ) ) {
	    System.out.println( "====削除成功====" );
//	    for ( ToDo row: mapper.selectAll() ) {
	    for ( ToDo row: service.findAllToDo() ) {
	      System.out.println( row );
	    }
	  } else {
	    System.out.println( "====削除失敗====" );
	  }
	  
	}

}
