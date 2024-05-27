package com.harsh.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.List;

//this the static list of todo (step by step appoach to databases)
public class TodoService {
    
    private static List<Todo> todos;
    static
    {
        todos.add(new Todo(1, "harsh", "learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "harsh", "learn DEVOPS", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(2, "harsh", "learn Full Stack", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username)
    {
        return todos;
    }
}
