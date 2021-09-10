package com.websaya.m_sismalv4.ui.desa_fokus_aktif;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class DesaFokusAktifRepository {
    private SismalDao mDao;
    private LiveData<List<DesaFokusAktif>> mAllData;

    DesaFokusAktifRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllDesaFokusAktif();
    }

    LiveData<List<DesaFokusAktif>> getAllData() {
        return mAllData;
    }

    public void insert (DesaFokusAktif DesaFokusAktif) {
        new insertAsyncTask(mDao).execute(DesaFokusAktif);
    }

    private static class insertAsyncTask extends AsyncTask<DesaFokusAktif, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final DesaFokusAktif... params) {
            mAsyncTaskDao.insertDesaFokusAktif(params[0]);
            return null;
        }
    }
}
