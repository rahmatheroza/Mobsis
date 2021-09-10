package com.websaya.m_sismalv4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.websaya.m_sismalv4.ui.desa.Desa;
import com.websaya.m_sismalv4.ui.desa_fokus_aktif.DesaFokusAktif;
import com.websaya.m_sismalv4.ui.fokus_aktif.FokusAktif;
import com.websaya.m_sismalv4.ui.hasil_notifikasi.HasilNotifikasi;
import com.websaya.m_sismalv4.ui.info_kunci.InfoKunci;
import com.websaya.m_sismalv4.ui.r2_data_logistik.DataLogistik;
import com.websaya.m_sismalv4.ui.r2_data_penemuan.DataPenemuan;
import com.websaya.m_sismalv4.ui.r2_data_uji_silang.DataUjiSilang;
import com.websaya.m_sismalv4.ui.r2_stok_obat.StokObat;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1;
import com.websaya.m_sismalv4.ui.vektor.Vektor;

import java.util.List;

@Dao
public interface SismalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertInfoKunci(InfoKunci infoKunci);

    @Update
    public void updateInfoKunci(InfoKunci... infoKunci);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDesa(Desa desa);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertRegmal1(Regmal1 regmal1);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDataPenemuan(DataPenemuan data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDataLogistik(DataLogistik data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertStokObat(StokObat data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertVektor(Vektor data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDataUjiSilang(DataUjiSilang data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertDesaFokusAktif(DesaFokusAktif data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFokusAktif(FokusAktif data);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertHasilNotifikasi(HasilNotifikasi data);

    @Query("DELETE FROM info_kunci_table")
    void deleteAll();

    @Query("SELECT * from desa_table ORDER BY id DESC")
    LiveData<List<Desa>> getAllDesa();

    @Query("SELECT * from info_kunci_table LIMIT 1")
    LiveData<InfoKunci> getInfoKunci();

    @Query("SELECT * from regmal1_table ORDER BY id DESC")
    LiveData<List<Regmal1>> getAllRegmal1();

    @Query("SELECT * from data_penemuan_table ORDER BY id DESC")
    LiveData<List<DataPenemuan>> getAllDataPenemuan();

    @Query("SELECT * from data_logistik_table ORDER BY id DESC")
    LiveData<List<DataLogistik>> getAllDataLogistik();

    @Query("SELECT * from stok_obat_table ORDER BY id DESC")
    LiveData<List<StokObat>> getAllStokObat();

    @Query("SELECT * from data_uji_silang_table ORDER BY id DESC")
    LiveData<List<DataUjiSilang>> getAllDataUjiSilang();

    @Query("SELECT * from vektor_table ORDER BY id DESC")
    LiveData<List<Vektor>> getAllVektor();

    @Query("SELECT * from desa_fokus_aktif_table ORDER BY id DESC")
    LiveData<List<DesaFokusAktif>> getAllDesaFokusAktif();

    @Query("SELECT * from fokus_aktif_table ORDER BY id DESC")
    LiveData<List<FokusAktif>> getAllFokusAktif();

    @Query("SELECT * from hasil_notifikasi_table ORDER BY id DESC")
    LiveData<List<HasilNotifikasi>> getAllHasilNotifikasi();
}
