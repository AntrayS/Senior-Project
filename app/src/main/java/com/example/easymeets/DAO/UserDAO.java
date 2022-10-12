package com.example.easymeets.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymeets.entities.User;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM users")
    public Single<List<User>> getAll();
    @Query("SELECT * FROM users WHERE users.userId = :id")
    public Single<User> getByID(long id);
    @Query("SELECT * FROM users WHERE users.username = :username")
    public Single<User> getByName(String username);
    @Insert
    public Completable insertUser(User user);
    @Delete
    public Completable deleteUser(User user);
    @Query("SELECT * FROM users WHERE users.username = :username AND users.username = :password")
    public Single<User> getByNameAndPass(String username, String password);
}
