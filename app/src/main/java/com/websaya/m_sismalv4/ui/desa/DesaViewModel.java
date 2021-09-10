package com.websaya.m_sismalv4.ui.desa;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DesaViewModel extends AndroidViewModel {
    private DesaRepository mRepository;

    private LiveData<List<Desa>> mAllDesa;

    public DesaViewModel (Application application) {
        super(application);
        mRepository = new DesaRepository(application);
        mAllDesa = mRepository.getAllDesa();
    }

    public LiveData<List<Desa>> getAllDesa() { return mAllDesa; }

    public void insert(Desa desa) { mRepository.insert(desa); }
}
