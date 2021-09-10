package com.websaya.m_sismalv4.ui.regmal1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Regmal1Dao {

    @Insert
    void insert(Regmal1 regmal1);

    @Query("DELETE FROM regmal1_table")
    void deleteAll();

    @Query("SELECT * from regmal1_table ORDER BY id DESC")
    LiveData<List<Regmal1>> getAllRegmal1();
}
