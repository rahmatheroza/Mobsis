package com.websaya.m_sismalv4.ui.r2_data_penemuan;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class DataPenemuanRepository {
    private SismalDao mDao;
    private LiveData<List<DataPenemuan>> mAllData;

    DataPenemuanRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllDataPenemuan();
    }

    LiveData<List<DataPenemuan>> getAllData() {
        return mAllData;
    }

    public void insert (DataPenemuan DataPenemuan) {
        new insertAsyncTask(mDao).execute(DataPenemuan);
    }

    private static class insertAsyncTask extends AsyncTask<DataPenemuan, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final DataPenemuan... params) {
            mAsyncTaskDao.insertDataPenemuan(params[0]);
            return null;
        }
    }
}
