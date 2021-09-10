package com.websaya.m_sismalv4.ui.r2_data_penemuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.websaya.m_sismalv4.R;

public class DataPenemuanInputActivity extends AppCompatActivity {

    public static final String EXTRA_BULAN = "EXTRA_BULAN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
//    private EditText mEditNamaPasien;
//    private EditText mEditDesaPasien;
    Spinner mSpinnerBulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_penemuan_form);
//        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
//        mEditDesaPasien = findViewById(R.id.editTextDesaPasien);

        mSpinnerBulan = (Spinner) findViewById(R.id.spinnerBulan);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.bulan_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerBulan.setAdapter(adapter1);
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
//            String namaPasien = mEditNamaPasien.getText().toString();
            String bulan = mSpinnerBulan.getSelectedItem().toString();
//            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_BULAN, bulan);
            setResult(RESULT_OK, replyIntent);
//        }
        finish();
        return true;
    }
}