package com.example.easymeets.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymeets.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    List<User> getAll();
    @Query("SELECT * FROM User WHERE User.userId = :id")
    User getByID(long id);
    @Query("SELECT * FROM User WHERE User.username = :username")
    User getByName(String username);
    @Insert
    void insertUser(User user);
    @Delete
    void deleteUser(User user);
}
