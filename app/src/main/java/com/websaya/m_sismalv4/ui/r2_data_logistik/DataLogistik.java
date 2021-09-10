package com.websaya.m_sismalv4.ui.r2_data_logistik;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_logistik_table")
public class DataLogistik {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mNama;
    private String mDesa;

    public DataLogistik(@NonNull int id, String nama, String desa) {
        this.mId = id;
        this.mDesa = desa;
        this.mNama = nama;
    }
    public int getId(){return this.mId;}
    public String getDesa(){return this.mDesa;}
    public String getNama(){return this.mNama;}
}
