package com.example.easymeets.entities;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.RenameTable;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName="groups")
public class Group {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private long groupID;
    @ColumnInfo(name="name")
    private String groupName;
    @Embedded
    private ArrayList<User> userList;
    @Embedded
    private ArrayList<String> topicsList;

    public Group(){

    }

    public Group(String name, ArrayList<String> topics){
        groupName = name;
        this.topicsList = topics;
        userList = new ArrayList<User>();
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
    public void addTopics(String topic){
        topicsList.add(topic);
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

    public ArrayList<String> getTopicsList() {
        return topicsList;
    }
    public void setTopicsList(ArrayList<String> topicsList){
        this.topicsList=topicsList;
    }

    public String toString(){
        String s = groupName;
        for(int i = 0; i < userList.size();i++){
            s += " " + userList.get(i).getUsername();
        }
        return s;
    }

}
