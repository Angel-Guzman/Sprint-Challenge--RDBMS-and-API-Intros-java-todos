package com.lambda.todolist.repository;

import com.lambda.todolist.models.User;
import com.lambda.todolist.views.UserTodosCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    @Query(value = "SELECT u.username as usernamerpt, count(t.todoid) as counttodos " +
            "FROM users u " +
            "JOIN todos t " +
            "ON u.userid = t.userid " +
            "WHERE t.completed = false " +
            "GROUP BY u.username", nativeQuery = true)
    List<UserTodosCount> getCountUserTodos();
}