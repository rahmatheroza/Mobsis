package com.websaya.m_sismalv4.ui.r2_data_penemuan;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataPenemuanViewModel extends AndroidViewModel {
    private DataPenemuanRepository mRepository;

    private LiveData<List<DataPenemuan>> mAllData;

    public DataPenemuanViewModel(Application application) {
        super(application);
        mRepository = new DataPenemuanRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<DataPenemuan>> getAllData() { return mAllData; }

    public void insert(DataPenemuan dataPenemuan) { mRepository.insert(dataPenemuan); }
}
