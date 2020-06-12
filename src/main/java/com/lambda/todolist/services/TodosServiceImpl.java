package com.lambda.todolist.services;

import com.lambda.todolist.models.Todos;
import com.lambda.todolist.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{
    @Autowired
    private TodosRepository todosrepos;

    @Override
    public Todos save(Todos todo)
    {
        Todos newTodo = new Todos();

        if (todo.getTodoid() != 0)
        {
            todosrepos.findById(todo.getTodoid())
                    .orElseThrow(() -> new EntityNotFoundException("Todo " + todo.getTodoid() + " Not Found! "));
            newTodo.setTodoid(todo.getTodoid());
        }

        newTodo.setTodoid(todo.getTodoid());
        newTodo.setDescription(todo.getDescription());
        newTodo.setCompleted(todo.isCompleted());
        newTodo.setUserid(todo.getUserid());

        return todosrepos.save(newTodo);
    }

    @Override
    public Todos update(Todos todo, long id)
    {
        Todos currentTodo = todosrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo " + id + " Not Found! "));



        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());;
        }

        return todosrepos.save(currentTodo);
    }
}
