package com.websaya.m_sismalv4.ui.r2_data_uji_silang;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.websaya.m_sismalv4.R;

public class DataUjiSilangInputActivity extends AppCompatActivity {

    public static final String EXTRA_DESA_PASIEN = "EXTRA_DESA_PASIEN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
    private EditText mEditNamaPasien;
    private EditText mEditDesaPasien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_form);
        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
        mEditDesaPasien = findViewById(R.id.editTextDesaPasien);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditNamaPasien.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String namaPasien = mEditNamaPasien.getText().toString();
            String desaPasien = mEditDesaPasien.getText().toString();
            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA_PASIEN, desaPasien);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
        return true;
    }
}