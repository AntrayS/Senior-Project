package com.example.easymeets.entities;

import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.easymeets.entities.Group;
import java.util.List;

@Entity
public class User {
    @PrimaryKey
    private long userId;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name="password")
    private String password;
    private Image profilePic;

    private List<Group> groups;
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        return username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Image getProfilePic(){
        return profilePic;
    }

    public void setProfilePic(Image pic){profilePic = pic;}

    public void addGroup(Group group){
        groups.add(group);
    }

    public void leaveGroup(Group group){
        groups.remove(group);
    }

}
