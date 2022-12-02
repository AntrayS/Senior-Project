package com.example.easymeets.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName="groups")
public class Group {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long groupID;
    @ColumnInfo(name="name")
    private String groupName;
    @Embedded
    private ArrayList<User> userList;
    @ColumnInfo(name="Topic")
    private String topics;

    public Group(String name, String topics){
        groupName = name;
        this.topics = topics;
        userList = new ArrayList<User>();
    }
    public Group(){

    }
    public String getGroupName(){
        return groupName;
    }
    public void setGroupName(String name){
        groupName = name;
    }
    public void addUser(User user){
        userList.add(user);
    }
    public void removeUser(User user){
        userList.remove(user);
    }

    public long getGroupID(){
        return groupID;
    }
    public void setGroupID(long id){
        groupID = id;
    }
    public ArrayList<User> getUserList(){
        return userList;
    }
    public void setUserList(ArrayList<User> userList){
        this.userList = userList;
    }



    public String toString(){
        String s = groupName;
        for(int i = 0; i < userList.size();i++){
            s += " " + userList.get(i).getUsername();
        }
        return s;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }
}
