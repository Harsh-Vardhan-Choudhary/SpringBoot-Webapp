package com.harsh.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
//this the static list of todo (step by step appoach to databases)
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 1;
    
    static
    {
        todos.add(new Todo(todosCount, "harsh", "learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(todosCount++, "harsh", "learn DEVOPS", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(todosCount++, "harsh", "learn Full Stack", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username)
    {
		    return todos;
	  }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done)
    {
        Todo todo = new Todo(todosCount++, username, description, targetDate, done);
        todos.add(todo);
    }
}
