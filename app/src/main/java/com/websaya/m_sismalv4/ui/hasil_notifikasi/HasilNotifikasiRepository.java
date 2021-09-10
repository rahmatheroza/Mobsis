package com.websaya.m_sismalv4.ui.hasil_notifikasi;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class HasilNotifikasiRepository {
    private SismalDao mDao;
    private LiveData<List<HasilNotifikasi>> mAllData;

    HasilNotifikasiRepository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mDao = db.sismalDao();
        mAllData = mDao.getAllHasilNotifikasi();
    }

    LiveData<List<HasilNotifikasi>> getAllData() {
        return mAllData;
    }

    public void insert (HasilNotifikasi HasilNotifikasi) {
        new insertAsyncTask(mDao).execute(HasilNotifikasi);
    }

    private static class insertAsyncTask extends AsyncTask<HasilNotifikasi, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final HasilNotifikasi... params) {
            mAsyncTaskDao.insertHasilNotifikasi(params[0]);
            return null;
        }
    }
}
