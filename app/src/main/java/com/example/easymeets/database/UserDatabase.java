package com.example.easymeets.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.entities.User;

@Database(entities = {User.class},version=1)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
}
