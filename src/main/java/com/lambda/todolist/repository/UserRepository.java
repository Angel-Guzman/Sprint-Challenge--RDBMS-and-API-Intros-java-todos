package com.lambda.todolist.repository;

import com.lambda.todolist.models.User;
import com.lambda.todolist.views.JustTheCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    @Query(value = "SELECT COUNT(*) as count FROM todos WHERE completed = :completedid", nativeQuery = true)
    JustTheCount checkTodos(boolean completedid);
}
