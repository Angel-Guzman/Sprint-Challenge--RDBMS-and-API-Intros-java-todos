package com.lambda.todolist.controllers;

import com.lambda.todolist.models.User;
import com.lambda.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> listAllUsers()
    {
        List<User> myUsers = userService.findAll();
        return new ResponseEntity<>(myUsers, HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}", produces = {"application/json"})
    public ResponseEntity<?> getUserById(@PathVariable Long userId)
    {
        User u = userService.findUserById(userId);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping(value = "/userid/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable long userId)
    {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
