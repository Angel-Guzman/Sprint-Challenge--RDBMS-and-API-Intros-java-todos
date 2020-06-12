package com.lambda.todolist.repository;

import com.lambda.todolist.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}
