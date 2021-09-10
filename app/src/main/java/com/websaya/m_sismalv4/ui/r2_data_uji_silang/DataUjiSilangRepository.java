package com.websaya.m_sismalv4.ui.r2_data_uji_silang;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class DataUjiSilangRepository {
    private SismalDao mDao;
    private LiveData<List<DataUjiSilang>> mAllData;

    DataUjiSilangRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllDataUjiSilang();
    }

    LiveData<List<DataUjiSilang>> getAllData() {
        return mAllData;
    }

    public void insert (DataUjiSilang DataUjiSilang) {
        new insertAsyncTask(mDao).execute(DataUjiSilang);
    }

    private static class insertAsyncTask extends AsyncTask<DataUjiSilang, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final DataUjiSilang... params) {
            mAsyncTaskDao.insertDataUjiSilang(params[0]);
            return null;
        }
    }
}
