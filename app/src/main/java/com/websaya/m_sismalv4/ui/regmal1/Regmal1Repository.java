package com.websaya.m_sismalv4.ui.regmal1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.websaya.m_sismalv4.SismalDao;
import com.websaya.m_sismalv4.SismalRoomDatabase;

import java.util.List;

public class Regmal1Repository {
    private SismalDao mRegmal1Dao;
    private LiveData<List<Regmal1>> mAllRegmal1;

    Regmal1Repository(Application application) {
        SismalRoomDatabase db = SismalRoomDatabase.getDatabase(application);
        mRegmal1Dao = db.sismalDao();
        mAllRegmal1 = mRegmal1Dao.getAllRegmal1();
    }

    LiveData<List<Regmal1>> getAllRegmal1() {
        return mAllRegmal1;
    }

    public void insert (Regmal1 Regmal1) {
        new insertAsyncTask(mRegmal1Dao).execute(Regmal1);
    }

    private static class insertAsyncTask extends AsyncTask<Regmal1, Void, Void> {

        private SismalDao mAsyncTaskDao;

        insertAsyncTask(SismalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Regmal1... params) {
            mAsyncTaskDao.insertRegmal1(params[0]);
            return null;
        }
    }
}
