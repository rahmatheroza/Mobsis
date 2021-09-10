package com.websaya.m_sismalv4;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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

@Database(entities = {Desa.class, InfoKunci.class, DataPenemuan.class, Regmal1.class, DataLogistik.class, StokObat.class, DataUjiSilang.class, Vektor.class, DesaFokusAktif.class, FokusAktif.class, HasilNotifikasi.class}, version = 1, exportSchema = false)
public abstract class SismalRoomDatabase extends RoomDatabase {
    public abstract SismalDao sismalDao();
    private static SismalRoomDatabase INSTANCE;

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };



    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final SismalDao mDao;


        PopulateDbAsync(SismalRoomDatabase db) {
            mDao = db.sismalDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            //mDao.deleteAll();
            mDao.insertInfoKunci(new InfoKunci(1, "Sri Midawati, Am. Keb.", "2020", "South Sumatera", "Lahat", "PAGAR JATI", "PUSKESMAS PAGAR JATI", "12"));

            mDao.insertDesa(new Desa(1, "", "Luar Wilayah Puskesmas", "0", "0", "0", "0", "0", "12/20"));
            mDao.insertDesa(new Desa(2, "", "Luar Wilayah Kabupaten", "0", "0", "0", "0", "0", "12/20"));
            mDao.insertDesa(new Desa(3, "", "Luar Wilayah Provinsi", "0", "0", "0", "0", "0", "12/20"));
            mDao.insertDesa(new Desa(4, "", "Luar Wilayah Negara", "0", "0", "0", "0", "0", "12/20"));

            return null;
        }
    }

    public static SismalRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SismalRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SismalRoomDatabase.class, "the_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
