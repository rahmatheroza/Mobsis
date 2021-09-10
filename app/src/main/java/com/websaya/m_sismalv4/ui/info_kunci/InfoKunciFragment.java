package com.websaya.m_sismalv4.ui.info_kunci;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.websaya.m_sismalv4.MainActivity;
import com.websaya.m_sismalv4.R;

public class InfoKunciFragment extends Fragment {
    private InfoKunciViewModel mViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.infokunci, container, false);

        mViewModel = ViewModelProviders.of(this).get(InfoKunciViewModel.class);
        mViewModel.getInfoKunci().observe(getActivity(), new Observer<InfoKunci>() {
            @Override
            public void onChanged(InfoKunci infoKunci) {
                ((TextView)root.findViewById(R.id.fieldNamaPetugas)).setText(infoKunci.getNamaPetugas());
                ((TextView)root.findViewById(R.id.fieldTahun)).setText(infoKunci.getTahunPencatatan());
                ((TextView)root.findViewById(R.id.fieldPropinsi)).setText(infoKunci.getPropinsi());
                ((TextView)root.findViewById(R.id.fieldKabKota)).setText(infoKunci.getKabKota());
                ((TextView)root.findViewById(R.id.fieldKec)).setText(infoKunci.getKecamatan());
                ((TextView)root.findViewById(R.id.fieldNamaFaskes)).setText(infoKunci.getNamaFaskes());
                ((TextView)root.findViewById(R.id.fieldAPIKab)).setText(infoKunci.getApiKab());
            }
        });

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getContext(), UpdateInfoKunciActivity.class);
                getActivity().startActivityForResult(intent, MainActivity.UPDATE_INFO_KUNCI_ACTIVITY_REQUEST_CODE);
            }
        });

        return root;
    }
}