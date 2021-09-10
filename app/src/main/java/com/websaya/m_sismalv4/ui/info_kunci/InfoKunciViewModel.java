package com.websaya.m_sismalv4.ui.info_kunci;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class InfoKunciViewModel extends AndroidViewModel {
    private InfoKunciRepository mRepository;

    private LiveData<InfoKunci> mInfoKunci;

    public InfoKunciViewModel(Application application) {
        super(application);
        mRepository = new InfoKunciRepository(application);
        mInfoKunci = mRepository.getInfoKunci();
    }

    public LiveData<InfoKunci> getInfoKunci() { return mInfoKunci; }

    public void insert(InfoKunci infoKunci) { mRepository.insert(infoKunci); }

    public void update(InfoKunci infoKunci) {
        mRepository.update(infoKunci);
    }
}
