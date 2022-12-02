package com.example.easymeets.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM users")
    public Single<List<User>> getAll();
    @Query("SELECT * FROM users WHERE users.userId = :id")
    public User getByID(long id);
    @Query("SELECT * FROM users WHERE users.username = :username")
    public User getByName(String username);
    @Insert(entity = User.class,onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(User user);
    @Delete
    public void deleteUser(User user);
    @Query("SELECT * FROM users WHERE users.username = :username AND users.username = :password")
    public User getByNameAndPass(String username, String password);
}
