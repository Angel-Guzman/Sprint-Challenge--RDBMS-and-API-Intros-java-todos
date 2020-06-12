package com.lambda.todolist.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Auditable implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    private String primaryemail;

    @OneToMany(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "userid")
    private List<Todos> todos = new ArrayList<>();

    public User()
    {
    }

    public User(String username, String password, String primaryemail)
    {
        this.username = username;
        this.password = password;
        this.primaryemail = primaryemail;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPrimaryemail()
    {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail;
    }

    public List<Todos> getTodos()
    {
        return todos;
    }

    public void setTodos(List<Todos> todos)
    {
        this.todos = todos;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", primaryemail='" + primaryemail + '\'' +
                ", todos=" + todos +
                '}';
    }
}
