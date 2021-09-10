package com.websaya.m_sismalv4.ui.info_kunci;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;


import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class InfoKunciRepository {
    private SismalDao mInfoKunciDao;
    private LiveData<InfoKunci> mInfoKunci;

    InfoKunciRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mInfoKunciDao = db.sismalDao();
        mInfoKunci = mInfoKunciDao.getInfoKunci();
    }

    LiveData<InfoKunci> getInfoKunci() {
        return mInfoKunci;
    }

    public void insert(InfoKunci infoKunci) {
        new insertAsyncTask(mInfoKunciDao).execute(infoKunci);
    }

    public void update(InfoKunci infoKunci) {
        new updateAsyncTask(mInfoKunciDao).execute(infoKunci);
    }

    private static class insertAsyncTask extends AsyncTask<InfoKunci, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final InfoKunci... params) {
            mAsyncTaskDao.insertInfoKunci(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<InfoKunci, Void, Void> {

        private SismalDao mAsyncTaskDao;

        updateAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final InfoKunci... params) {
            mAsyncTaskDao.updateInfoKunci(params[0]);
            return null;
        }
    }
}
