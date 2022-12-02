package com.example.easymeets.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.easymeets.DAO.GroupDAO;
import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;

@Database(entities = {User.class, Group.class},version=1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDao();
    public abstract GroupDAO groupDao();

    private static AppDatabase instance;
    public static AppDatabase getDatabase(final Context context){
        if(instance == null){
            synchronized (AppDatabase.class) {
                instance = Room.databaseBuilder(context, AppDatabase.class, "DATABASE").allowMainThreadQueries().build();
            }
        }
        return instance;
    }
}
