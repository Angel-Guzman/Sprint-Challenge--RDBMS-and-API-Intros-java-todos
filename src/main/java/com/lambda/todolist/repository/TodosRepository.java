package com.lambda.todolist.repository;

import com.lambda.todolist.models.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos, Long>
{
}
