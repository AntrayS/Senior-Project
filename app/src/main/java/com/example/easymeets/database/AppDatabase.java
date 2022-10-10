package com.example.easymeets.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.easymeets.DAO.GroupDAO;
import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;

@Database(entities={User.class, Group.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public abstract GroupDAO groupDao();
}
