package com.websaya.m_sismalv4.ui.fokus_aktif;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class FokusAktifRepository {
    private SismalDao mDao;
    private LiveData<List<FokusAktif>> mAllData;

    FokusAktifRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllFokusAktif();
    }

    LiveData<List<FokusAktif>> getAllData() {
        return mAllData;
    }

    public void insert (FokusAktif FokusAktif) {
        new insertAsyncTask(mDao).execute(FokusAktif);
    }

    private static class insertAsyncTask extends AsyncTask<FokusAktif, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FokusAktif... params) {
            mAsyncTaskDao.insertFokusAktif(params[0]);
            return null;
        }
    }
}
