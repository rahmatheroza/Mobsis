package com.websaya.m_sismalv4.ui.r2_data_penemuan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_penemuan_table")
public class DataPenemuan {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;

    private String mBulan;

    public DataPenemuan(@NonNull int id, String bulan) {
        this.mId = id;
        this.mBulan = bulan;

    }
    public int getId(){return this.mId;}
    public String getBulan(){return this.mBulan;}
}
