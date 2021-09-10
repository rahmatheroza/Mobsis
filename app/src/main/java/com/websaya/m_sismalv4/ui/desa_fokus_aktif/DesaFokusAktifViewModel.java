package com.websaya.m_sismalv4.ui.desa_fokus_aktif;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DesaFokusAktifViewModel extends AndroidViewModel {
    private DesaFokusAktifRepository mRepository;

    private LiveData<List<DesaFokusAktif>> mAllData;

    public DesaFokusAktifViewModel(Application application) {
        super(application);
        mRepository = new DesaFokusAktifRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<DesaFokusAktif>> getAllData() { return mAllData; }

    public void insert(DesaFokusAktif desaFokusAktif) { mRepository.insert(desaFokusAktif); }
}
