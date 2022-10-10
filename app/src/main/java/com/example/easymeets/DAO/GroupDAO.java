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
    public Single<Group> getByID(long id);
    @Insert
    public Completable addGroup(Group group);
    @Delete
    public Completable deleteGroup(Group group);
}
