package com.harsh.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}

	private TodoService todoService;

	private TodoRepository todoRepository;
		
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) 
	{
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}

	//GET, POST
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) 
	{
		//(String)model.get("name")
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		//so when we are creating new todo we are setting default values here

		model.put("todo", todo);
		return "todo";

		//error msg - neither binding result nor plain targer object for being todo available as request attribute
		//the problem is that TodoController showNewTodoPage method which is called whne add to do is called
		//This one is not setting an attribute called to do into the model
	}

	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) 
	{
		if (result.hasErrors()) 
		{
			return "todo";
		}

		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);

		//todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);

		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodo(@RequestParam int id, ModelMap model)
	{
		Todo todo = todoRepository.findById(id).get();

		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if (result.hasErrors()) 
		{
			return "todo";
		}

		//we dont want to loose username after update that is why we are specifiying it here
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);

		//todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) 
	{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return name;
	}

}