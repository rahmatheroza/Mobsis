package com.websaya.m_sismalv4.ui.vektor;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class VektorViewModel extends AndroidViewModel {
    private VektorRepository mRepository;

    private LiveData<List<Vektor>> mAllData;

    public VektorViewModel(Application application) {
        super(application);
        mRepository = new VektorRepository(application);
        mAllData = mRepository.getAllData();
    }

    public LiveData<List<Vektor>> getAllData() { return mAllData; }

    public void insert(Vektor vektor) { mRepository.insert(vektor); }
}
