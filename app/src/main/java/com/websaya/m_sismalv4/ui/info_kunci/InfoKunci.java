package com.websaya.m_sismalv4.ui.info_kunci;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "info_kunci_table")
public class InfoKunci {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")

    private int mId;
    private String mNamaPetugas;
    private String mTahunPencatatan;
    private String mPropinsi;
    private String mKabKota;
    private String mKecamatan;
    private String mNamaFaskes;
    private String mApiKab;

    public InfoKunci(@NonNull int id, String namaPetugas, String tahunPencatatan, String propinsi, String kabKota, String kecamatan, String namaFaskes, String apiKab) {
        this.mId = id;
        this.mNamaPetugas = namaPetugas;
        this.mTahunPencatatan = tahunPencatatan;
        this.mPropinsi = propinsi;
        this.mKabKota = kabKota;
        this.mKecamatan = kecamatan;
        this.mNamaFaskes = namaFaskes;
        this.mApiKab = apiKab;
    }
    public int getId(){return this.mId;}
    public String getNamaPetugas(){return this.mNamaPetugas;}
    public String getTahunPencatatan(){return this.mTahunPencatatan;}
    public String getPropinsi(){return this.mPropinsi;}
    public String getKabKota(){return this.mKabKota;}
    public String getKecamatan(){return this.mKecamatan;}
    public String getNamaFaskes(){return this.mNamaFaskes;}
    public String getApiKab(){return this.mApiKab;}
}
