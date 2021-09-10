package com.websaya.m_sismalv4.ui.r2_data_logistik;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataLogistikViewModel extends AndroidViewModel {
    private DataLogistikRepository mRepository;

    private LiveData<List<DataLogistik>> mAllData;

    public DataLogistikViewModel(Application application) {
        super(application);
        mRepository = new DataLogistikRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<DataLogistik>> getAllData() { return mAllData; }

    public void insert(DataLogistik dataLogistik) { mRepository.insert(dataLogistik); }
}
