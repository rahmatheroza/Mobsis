package com.websaya.m_sismalv4.ui.vektor;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vektor_table")
public class Vektor {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mNama;
    private String mDesa;

    public Vektor(@NonNull int id, String nama, String desa) {
        this.mId = id;
        this.mDesa = desa;
        this.mNama = nama;
    }
    public int getId(){return this.mId;}
    public String getDesa(){return this.mDesa;}
    public String getNama(){return this.mNama;}
}
