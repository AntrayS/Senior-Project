package com.example.easymeets.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymeets.entities.Group;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface GroupDAO {
    @Query("SELECT * FROM groups")
    public Single<List<Group>> getAll();
    @Query("SELECT * FROM groups WHERE groups.id = :id")
    public Group getByID(long id);
    @Query("SELECT * FROM groups WHERE groups.name = :name")
    public Group getByName(String name);
    @Query("SELECT * FROM groups WHERE groups.topic = :topic")
    public Group getByID(String topic);
    @Insert
    public Completable addGroup(Group group);
    @Delete
    public Completable deleteGroup(Group group);
}
