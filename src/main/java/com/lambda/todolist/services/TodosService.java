package com.lambda.todolist.services;

import com.lambda.todolist.models.Todos;

public interface TodosService
{
    Todos save(Todos todo);

    Todos update(long id);
}
