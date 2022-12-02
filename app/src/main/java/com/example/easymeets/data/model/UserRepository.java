package com.example.easymeets.data.model;

import com.example.easymeets.DAO.GroupDAO;
import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;
import com.example.easymeets.DAO.UserDAO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class UserRepository {
    UserDAO userDAO;
    GroupDAO groupDAO;
    void addUser(User user){
        userDAO.insertUser(user);
    }
    void deleteUser(User user){
        userDAO.deleteUser(user);
    }
    void joinGroup(User user, Group group){
        user.addGroup(group);
        userDAO.insertUser(user);
        group.addUser(user);
        groupDAO.addGroup(group);
    }
    List<String> getDetails(long userID){
        User user = userDAO.getByID(userID);
        ArrayList<String> l = new ArrayList<String>();
        l.add(user.getUsername());
        l.add(user.getBio());
        return l;
    }
    String loginUser(String username, String password){
        User user = userDAO.getByName(username);
        if(user.getPassword().equals(password)){
            return "Login successful";
        }
        else{
            return "Username or password is incorrect.";
        }
    }
}

