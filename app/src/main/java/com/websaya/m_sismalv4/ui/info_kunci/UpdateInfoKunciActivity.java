package com.websaya.m_sismalv4.ui.info_kunci;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.websaya.m_sismalv4.R;

public class UpdateInfoKunciActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "EXTRA_NAMA";
    public static final String EXTRA_TAHUN = "EXTRA_TAHUN";
    private EditText mEditNama;
    private EditText mEditTahun;
    private EditText mEditPropinsi;
    private EditText mEditKabKota;
    private EditText mEditKecamatan;
    private EditText mEditNamaFaskes;
    private EditText mEditApiKab;
    private InfoKunciViewModel mInfoKunciViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infokunci_form);
        mEditNama = findViewById(R.id.fieldNamaPetugas);
        mEditTahun = findViewById(R.id.fieldTahun);
        mEditPropinsi = findViewById(R.id.fieldPropinsi);
        mEditKabKota = findViewById(R.id.fieldKabKota);
        mEditKecamatan = findViewById(R.id.fieldKec);
        mEditNamaFaskes = findViewById(R.id.fieldNamaFaskes);
        mEditApiKab = findViewById(R.id.fieldAPIKab);
        mInfoKunciViewModel = ViewModelProviders.of(this).get(InfoKunciViewModel.class);
        mInfoKunciViewModel.getInfoKunci().observe(this, new Observer<InfoKunci>() {
            @Override
            public void onChanged(InfoKunci infoKunci) {
                mEditNama.setText(infoKunci.getNamaPetugas());
                mEditTahun.setText(infoKunci.getTahunPencatatan());
                mEditPropinsi.setText(infoKunci.getPropinsi());
                mEditKabKota.setText(infoKunci.getKabKota());
                mEditKecamatan.setText(infoKunci.getKecamatan());
                mEditNamaFaskes.setText(infoKunci.getNamaFaskes());
                mEditApiKab.setText(infoKunci.getApiKab());
            }
        });

        populateData();
    }

    private void populateData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditNama.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            InfoKunci infoKunci = new InfoKunci(1, mEditNama.getText().toString(), mEditTahun.getText().toString(), mEditPropinsi.getText().toString(), mEditKabKota.getText().toString(), mEditKecamatan.getText().toString(), mEditNamaFaskes.getText().toString(), mEditApiKab.getText().toString());
            mInfoKunciViewModel.update(infoKunci);

            setResult(RESULT_OK, replyIntent);
        }
        finish();
        return true;
    }
}