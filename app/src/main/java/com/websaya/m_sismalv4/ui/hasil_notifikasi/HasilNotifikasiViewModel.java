package com.websaya.m_sismalv4.ui.hasil_notifikasi;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HasilNotifikasiViewModel extends AndroidViewModel {
    private HasilNotifikasiRepository mRepository;

    private LiveData<List<HasilNotifikasi>> mAllData;

    public HasilNotifikasiViewModel(Application application) {
        super(application);
        mRepository = new HasilNotifikasiRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<HasilNotifikasi>> getAllData() { return mAllData; }

    public void insert(HasilNotifikasi hasilNotifikasi) { mRepository.insert(hasilNotifikasi); }
}
