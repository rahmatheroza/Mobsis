package com.websaya.m_sismalv4.ui.r2_stok_obat;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class StokObatRepository {
    private SismalDao mDao;
    private LiveData<List<StokObat>> mAllData;

    StokObatRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllStokObat();
    }

    LiveData<List<StokObat>> getAllData() {
        return mAllData;
    }

    public void insert (StokObat StokObat) {
        new insertAsyncTask(mDao).execute(StokObat);
    }

    private static class insertAsyncTask extends AsyncTask<StokObat, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final StokObat... params) {
            mAsyncTaskDao.insertStokObat(params[0]);
            return null;
        }
    }
}
