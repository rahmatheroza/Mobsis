package com.websaya.m_sismalv4.ui.vektor;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class VektorRepository {
    private SismalDao mDao;
    private LiveData<List<Vektor>> mAllData;

    VektorRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllVektor();
    }

    LiveData<List<Vektor>> getAllData() {
        return mAllData;
    }

    public void insert (Vektor Vektor) {
        new insertAsyncTask(mDao).execute(Vektor);
    }

    private static class insertAsyncTask extends AsyncTask<Vektor, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Vektor... params) {
            mAsyncTaskDao.insertVektor(params[0]);
            return null;
        }
    }
}
