package com.websaya.m_sismalv4.ui.hasil_notifikasi;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hasil_notifikasi_table")
public class HasilNotifikasi {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mNama;
    private String mDesa;

    public HasilNotifikasi(@NonNull int id, String nama, String desa) {
        this.mId = id;
        this.mDesa = desa;
        this.mNama = nama;
    }
    public int getId(){return this.mId;}
    public String getDesa(){return this.mDesa;}
    public String getNama(){return this.mNama;}
}
