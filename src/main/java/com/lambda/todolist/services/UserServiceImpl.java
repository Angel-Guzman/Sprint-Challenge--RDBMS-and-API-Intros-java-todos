package com.lambda.todolist.services;


import com.lambda.todolist.models.User;
import com.lambda.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public User findUserById(long id)
    {
        return null;
    }

    @Override
    public User save(User user)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public User update(User user, long id)
    {
        return null;
    }
}
