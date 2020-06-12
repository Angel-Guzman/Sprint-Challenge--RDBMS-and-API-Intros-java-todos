package com.lambda.todolist.controllers;

import com.lambda.todolist.models.Todos;
import com.lambda.todolist.models.User;
import com.lambda.todolist.repository.UserRepository;
import com.lambda.todolist.services.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/todos")
public class TodosController
{
    @Autowired
    private TodosService todosService;

    @Autowired
    private UserRepository usersrepo;

    @PostMapping(value = "/user/{userid}", consumes = {"application/json"})
    public ResponseEntity<?> addNewTodo(@Valid @RequestBody Todos newtodo, @PathVariable long userid) throws URISyntaxException
    {
        User user = usersrepo.findById(userid).orElseThrow(() -> new EntityNotFoundException("User " + userid + " Not Found! "));
        newtodo.setTodoid(0);
        newtodo.setUserid(user);
        todosService.save(newtodo);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newTodosURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/todoid}")
                .buildAndExpand(newtodo.getTodoid())
                .toUri();
        responseHeaders.setLocation(newTodosURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }
}
