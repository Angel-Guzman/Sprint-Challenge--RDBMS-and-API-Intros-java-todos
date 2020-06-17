package com.lambda.todolist.services;

import com.lambda.todolist.models.User;
import com.lambda.todolist.views.UserTodosCount;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findUserById(long id);

    User save(User user);

    void delete(long id);

    List<UserTodosCount> getCountUserTodos();

}
