package com.deimaphi.TodoApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deimaphi.TodoApplication.Entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	public List<Todo> findByUsername(String username);
	
	

}
