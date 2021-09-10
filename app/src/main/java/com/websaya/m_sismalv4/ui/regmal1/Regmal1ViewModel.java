package com.websaya.m_sismalv4.ui.regmal1;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Regmal1ViewModel extends AndroidViewModel {
    private Regmal1Repository mRepository;

    private LiveData<List<Regmal1>> mAllRegmal1;

    public Regmal1ViewModel(Application application) {
        super(application);
        mRepository = new Regmal1Repository(application);
        mAllRegmal1 = mRepository.getAllRegmal1();
    }

    public LiveData<List<Regmal1>> getAllRegmal1() { return mAllRegmal1; }

    public void insert(Regmal1 regmal1) { mRepository.insert(regmal1); }
}
