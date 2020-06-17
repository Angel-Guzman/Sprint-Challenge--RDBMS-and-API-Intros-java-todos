package com.lambda.todolist.services;


import com.lambda.todolist.models.Todos;
import com.lambda.todolist.models.User;
import com.lambda.todolist.repository.UserRepository;
import com.lambda.todolist.views.UserTodosCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userrepos;


    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();

        userrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);

        return list;
    }

    @Override
    public User findUserById(long id) throws EntityNotFoundException
    {
        return userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " Not Found! "));
    }

    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new EntityNotFoundException("User id " + user.getUserid() + " Not Found! "));
            newUser.setUserid(user.getUserid());
        }

        newUser.setUserid(user.getUserid());
        newUser.setUsername(user.getUsername());
        newUser.setPrimaryemail(user.getPrimaryemail());
        newUser.setPassword(user.getPassword());

        newUser.getTodos().clear();
        for (Todos t : user.getTodos())
        {
            newUser.getTodos().add(new Todos(newUser, t.getDescription()));
        }

        return userrepos.save(newUser);
    }

    @Override
    public void delete(long id)
    {
        userrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User id " + id + " Not Found! "));
        userrepos.deleteById(id);
    }

    @Override
    public List<UserTodosCount> getCountUserTodos()
    {
        return userrepos.getCountUserTodos();
    }
}
