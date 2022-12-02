package com.example.easymeets.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName="users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    private long userId;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name="password")
    private String password;
    @ColumnInfo(name="bio")
    private String bio;

    @Embedded
    private ArrayList<Group> groups;
    public User(String username, String password){
        this.setUsername(username);
        this.password = password;
        groups = new ArrayList<Group>();
    }
    public User(){

    }
    public long getUserId(){return userId;}

    public void setUserId(long userId){
        this.userId=userId;
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

    public String getPassword(){
        return password;
    }

    public ArrayList<Group> getGroups(){
        return groups;
    }

    public void setGroups(ArrayList<Group> groups){
        this.groups = groups;
    }

//    public Image getProfilePic(){
//        return profilePic;
//    }
//
//    public void setProfilePic(Image pic){profilePic = pic;}

    public void addGroup(Group group){
        groups.add(group);
    }

    public void leaveGroup(Group group){
        groups.remove(group);
    }

    @Override
    public String toString(){
        String s = getUsername();
        for(int i = 0; i < groups.size();i++){
            s += " " + groups.get(i).getGroupName();
        }
        return s;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
