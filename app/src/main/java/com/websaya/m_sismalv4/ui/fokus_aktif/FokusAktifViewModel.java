package com.websaya.m_sismalv4.ui.fokus_aktif;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FokusAktifViewModel extends AndroidViewModel {
    private FokusAktifRepository mRepository;

    private LiveData<List<FokusAktif>> mAllData;

    public FokusAktifViewModel(Application application) {
        super(application);
        mRepository = new FokusAktifRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<FokusAktif>> getAllData() { return mAllData; }

    public void insert(FokusAktif fokusAktif) { mRepository.insert(fokusAktif); }
}
