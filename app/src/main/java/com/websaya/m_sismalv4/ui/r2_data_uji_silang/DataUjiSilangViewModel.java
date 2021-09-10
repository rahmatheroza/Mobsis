package com.websaya.m_sismalv4.ui.r2_data_uji_silang;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataUjiSilangViewModel extends AndroidViewModel {
    private DataUjiSilangRepository mRepository;

    private LiveData<List<DataUjiSilang>> mAllData;

    public DataUjiSilangViewModel(Application application) {
        super(application);
        mRepository = new DataUjiSilangRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<DataUjiSilang>> getAllData() { return mAllData; }

    public void insert(DataUjiSilang dataUjiSilang) { mRepository.insert(dataUjiSilang); }
}
