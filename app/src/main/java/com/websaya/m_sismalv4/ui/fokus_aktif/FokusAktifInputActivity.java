package com.websaya.m_sismalv4.ui.fokus_aktif;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.websaya.m_sismalv4.R;

public class FokusAktifInputActivity extends AppCompatActivity {

    public static final String EXTRA_DESA_PASIEN = "EXTRA_DESA_PASIEN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
    private EditText mEditDesa;
//    private EditText mEditDesaPasien;
    public int datePickerIdx;
    EditText mTanggalKunjugan1;
    EditText mTanggalKunjugan2;
    EditText mTanggalKunjugan3;
    EditText mTanggalKunjugan4;
    EditText mTanggalKunjugan5;
    EditText mTanggalKunjugan6;
    EditText mTanggalKunjugan7;
    EditText mTanggalKunjugan8;
    EditText mTanggalKunjugan9;
    EditText mTanggalKunjugan10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fokus_aktif_form);
        mEditDesa = findViewById(R.id.editTextDesa);
//        mEditDesaPasien = findViewById(R.id.editTextDesaPasien);
        mTanggalKunjugan1 = findViewById(R.id.editTextTanggalKunjugan1);
        mTanggalKunjugan2 = findViewById(R.id.editTextTanggalKunjugan2);
        mTanggalKunjugan3 = findViewById(R.id.editTextTanggalKunjugan3);
        mTanggalKunjugan4 = findViewById(R.id.editTextTanggalKunjugan4);
        mTanggalKunjugan5 = findViewById(R.id.editTextTanggalKunjugan5);
        mTanggalKunjugan6 = findViewById(R.id.editTextTanggalKunjugan6);
        mTanggalKunjugan7 = findViewById(R.id.editTextTanggalKunjugan7);
        mTanggalKunjugan8 = findViewById(R.id.editTextTanggalKunjugan8);
        mTanggalKunjugan9 = findViewById(R.id.editTextTanggalKunjugan9);
        mTanggalKunjugan10 = findViewById(R.id.editTextTanggalKunjugan10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditDesa.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String namaPasien = mEditDesa.getText().toString();
            String desaPasien = mTanggalKunjugan1.getText().toString();
            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA_PASIEN, desaPasien);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
        return true;
    }

    public void showDatePicker(View view) {
        if (view.getId() == R.id.buttonTanggalKunjungan1)
            datePickerIdx = 1;
        else if (view.getId() == R.id.buttonTanggalKunjungan2)
            datePickerIdx = 2;
        else if (view.getId() == R.id.buttonTanggalKunjungan3)
            datePickerIdx = 3;
        else if (view.getId() == R.id.buttonTanggalKunjungan4)
            datePickerIdx = 4;
        else if (view.getId() == R.id.buttonTanggalKunjungan5)
            datePickerIdx = 5;
        else if (view.getId() == R.id.buttonTanggalKunjungan6)
            datePickerIdx = 6;
        else if (view.getId() == R.id.buttonTanggalKunjungan7)
            datePickerIdx = 7;
        else if (view.getId() == R.id.buttonTanggalKunjungan8)
            datePickerIdx = 8;
        else if (view.getId() == R.id.buttonTanggalKunjungan9)
            datePickerIdx = 9;
        else if (view.getId() == R.id.buttonTanggalKunjungan10)
            datePickerIdx = 10;
        else
            datePickerIdx = 0;
        DialogFragment newFragment = new FokusAktifDatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day, int idx) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string +
                "/" + month_string + "/" + year_string);
        if (idx == 1)
            mTanggalKunjugan1.setText(dateMessage);
        else if (idx == 2)
            mTanggalKunjugan2.setText(dateMessage);
        else if (idx == 3)
            mTanggalKunjugan3.setText(dateMessage);
        else if (idx == 4)
            mTanggalKunjugan4.setText(dateMessage);
        else if (idx == 5)
            mTanggalKunjugan5.setText(dateMessage);
        else if (idx == 6)
            mTanggalKunjugan6.setText(dateMessage);
        else if (idx == 7)
            mTanggalKunjugan7.setText(dateMessage);
        else if (idx == 8)
            mTanggalKunjugan8.setText(dateMessage);
        else if (idx == 9)
            mTanggalKunjugan9.setText(dateMessage);
        else if (idx == 10)
            mTanggalKunjugan10.setText(dateMessage);
    }
}