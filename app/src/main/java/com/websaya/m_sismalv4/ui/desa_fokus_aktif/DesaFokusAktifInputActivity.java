package com.websaya.m_sismalv4.ui.desa_fokus_aktif;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.websaya.m_sismalv4.R;
import com.websaya.m_sismalv4.ui.desa.Desa;
import com.websaya.m_sismalv4.ui.desa.DesaViewModel;

import java.util.ArrayList;
import java.util.List;

public class DesaFokusAktifInputActivity extends AppCompatActivity {

    public static final String EXTRA_DESA_PASIEN = "EXTRA_DESA_PASIEN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
//    private EditText mEditNamaPasien;
//    private EditText mEditDesaPasien;
    Spinner mSpinnerDesa;
    private DesaViewModel mDesaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desa_fokus_aktif_form);
//        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
//        mEditDesaPasien = findViewById(R.id.editTextDesaPasien);

        mSpinnerDesa = (Spinner) findViewById(R.id.spinnerDesa);
//        Spinner spinner22 = (Spinner) findViewById(R.id.spinnerDesaPE);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerDesa.setAdapter(adapter2);
//        spinner22.setAdapter(adapter2);
        mDesaViewModel = ViewModelProviders.of(this).get(DesaViewModel.class);
        mDesaViewModel.getAllDesa().observe(this, new Observer<List<Desa>>() {
            @Override
            public void onChanged(@Nullable final List<Desa> desas) {
                ArrayList<String> list = new ArrayList<String>();
                for (int i=0; i<desas.size(); i++) {
                    Desa desa = (Desa)desas.get(i);
                    list.add(desa.getNama());
                }
                adapter2.addAll(list);
                adapter2.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent replyIntent = new Intent();
//        if (TextUtils.isEmpty(mEditNamaPasien.getText())) {
//            setResult(RESULT_CANCELED, replyIntent);
//        } else {
            String namaPasien = mSpinnerDesa.getSelectedItem().toString();
            String desaPasien = "";
            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA_PASIEN, desaPasien);
            setResult(RESULT_OK, replyIntent);
//        }
        finish();
        return true;
    }
}