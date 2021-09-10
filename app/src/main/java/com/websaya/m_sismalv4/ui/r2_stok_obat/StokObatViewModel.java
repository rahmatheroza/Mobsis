package com.websaya.m_sismalv4.ui.r2_stok_obat;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StokObatViewModel extends AndroidViewModel {
    private StokObatRepository mRepository;

    private LiveData<List<StokObat>> mAllData;

    public StokObatViewModel(Application application) {
        super(application);
        mRepository = new StokObatRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<StokObat>> getAllData() { return mAllData; }

    public void insert(StokObat stokObat) { mRepository.insert(stokObat); }
}
