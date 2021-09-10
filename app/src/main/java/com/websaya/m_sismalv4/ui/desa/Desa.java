package com.websaya.m_sismalv4.ui.desa;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "desa_table")
public class Desa {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mKode;
    private String mNama;
    private String mJumlahPenduduk;
    private String mIbuHamil;
    private String mBayi;
    private String mBalita;
    private String mReseptifitas;
    private String mReseptifitasTanggal;

    public Desa(@NonNull int id, String kode, String nama, String jumlahPenduduk, String ibuHamil, String bayi, String balita, String reseptifitas, String reseptifitasTanggal) {
        this.mId = id;
        this.mKode = kode;
        this.mNama = nama;
        this.mJumlahPenduduk = jumlahPenduduk;
        this.mIbuHamil = ibuHamil;
        this.mBayi = bayi;
        this.mBalita = balita;
        this.mReseptifitas = reseptifitas;
        this.mReseptifitasTanggal = reseptifitasTanggal;
    }
    public int getId(){return this.mId;}
    public String getKode(){return this.mKode;}
    public String getNama(){return this.mNama;}
    public String getJumlahPenduduk(){return this.mJumlahPenduduk;}
    public String getIbuHamil(){return this.mIbuHamil;}
    public String getBayi(){return this.mBayi;}
    public String getBalita(){return this.mBalita;}
    public String getReseptifitas(){return this.mReseptifitas;}
    public String getReseptifitasTanggal(){return this.mReseptifitasTanggal;}
}
