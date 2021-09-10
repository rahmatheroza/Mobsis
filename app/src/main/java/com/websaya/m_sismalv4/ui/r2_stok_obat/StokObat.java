package com.websaya.m_sismalv4.ui.r2_stok_obat;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stok_obat_table")
public class StokObat {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mNama;
    private String mDesa;

    public StokObat(@NonNull int id, String nama, String desa) {
        this.mId = id;
        this.mDesa = desa;
        this.mNama = nama;
    }
    public int getId(){return this.mId;}
    public String getDesa(){return this.mDesa;}
    public String getNama(){return this.mNama;}
}
