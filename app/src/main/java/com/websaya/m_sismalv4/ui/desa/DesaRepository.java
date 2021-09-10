package com.websaya.m_sismalv4.ui.desa;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class DesaRepository {
    private SismalDao mDesaDao;
    private LiveData<List<Desa>> mAllDesas;

    DesaRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDesaDao = db.sismalDao();
        mAllDesas = mDesaDao.getAllDesa();
    }

    LiveData<List<Desa>> getAllDesa() {
        return mAllDesas;
    }

    public void insert (Desa Desa) {
        new insertAsyncTask(mDesaDao).execute(Desa);
    }

    private static class insertAsyncTask extends AsyncTask<Desa, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Desa... params) {
            mAsyncTaskDao.insertDesa(params[0]);
            return null;
        }
    }
}
