package com.example.easymeets.data.model;

import com.example.easymeets.DAO.GroupDAO;
import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    UserDAO userDAO;
    GroupDAO groupDAO;

    void addGroup(Group group) {
        groupDAO.addGroup(group);
    }
    void removeUser(Group group, User user){
        group.removeUser(user);
        user.leaveGroup(group);
        userDAO.insertUser(user);
        groupDAO.addGroup(group);
    }
    List<String> getUsers(Group group){
        ArrayList<String> l = new ArrayList<String>();
        for(int i = 0; i < group.getUserList().size();i++){
            l.add(group.getUserList().get(i).getUsername());
        }
        return l;
    }

}
