package com.deimaphi.TodoApplication.Controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.deimaphi.TodoApplication.Entity.Todo;
import com.deimaphi.TodoApplication.Repository.TodoRepository;

import jakarta.validation.Valid;

@Controller
public class TodoController {
private TodoRepository todoRepository;
	
	
	@Autowired
	public TodoController(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping(value="list-todos")
	public String listOfTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		
		model.put("todos", todos);
		return "listTodos";
	}

	
	@RequestMapping(value="add-todos", method=RequestMethod.GET)
	public String addTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo); //The "todo" should be the same as the modelAttribute of the form
		return "addTodo";
	}
	
	@RequestMapping(value="add-todos", method=RequestMethod.POST)
	public String listTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username=getLoggedinUsername(model);
		todo.setUsername(username);
		
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	@RequestMapping(value="delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showupdateTodos(@RequestParam int id,ModelMap model) {
		Todo todo = todoRepository.findById(id).get();
		
		model.put("todo", todo);
		return "addTodo";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String saveupdateTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
	
		String username=getLoggedinUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		if(todo.isDone()==true) {
			deleteTodos(todo.getId());
		}
		return "redirect:list-todos";
	}
	
	
}
