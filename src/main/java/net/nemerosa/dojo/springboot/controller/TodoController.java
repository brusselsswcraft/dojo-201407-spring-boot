package net.nemerosa.dojo.springboot.controller;

import net.nemerosa.dojo.springboot.model.Todo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final AtomicInteger id = new AtomicInteger(0);
    private final Map<Integer, Todo> todos = Collections.synchronizedMap(new TreeMap<>());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Collection<Todo> getTodoList() {
        return todos.values();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Todo create(@RequestBody String title) {
        Todo todo = Todo.of(id.incrementAndGet(), title);
        todos.put(todo.getId(), todo);
        return todo;
    }

}
