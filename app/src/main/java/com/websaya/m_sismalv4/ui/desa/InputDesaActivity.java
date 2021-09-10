package com.websaya.m_sismalv4.ui.desa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.websaya.m_sismalv4.R;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1DatePickerFragment;

public class InputDesaActivity extends AppCompatActivity {

    public static final String EXTRA_KODE_DESA = "EXTRA_KODE_DESA";
    public static final String EXTRA_NAMA_DESA = "EXTRA_NAMA_DESA";
    public static final String EXTRA_JUMLAHPENDUDUK = "EXTRA_JUMLAHPENDUDUK";
    public static final String EXTRA_IBUHAMIL = "EXTRA_IBUHAMIL";
    public static final String EXTRA_BAYI = "EXTRA_BAYI";
    public static final String EXTRA_BALITA = "EXTRA_BALITA";
    public static final String EXTRA_RESEPTIFITAS = "EXTRA_RESEPTIFITAS";
    public static final String EXTRA_RESEPTIFITASTANGGAL = "EXTRA_RESEPTIFITASTANGGAL";
    private EditText mEditKodeDesa;
    private EditText mEditNamaDesa;
    private EditText mEditJumlahPenduduk;
    private EditText mEditIbuHamil;
    private EditText mEditBayi;
    private EditText mEditBalita;
    private Switch mEditReseptifitas;
    private EditText mEditReseptifitasTanggal;
    public int datePickerIdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desa_form);
        mEditKodeDesa = findViewById(R.id.editTextKodeDesa);
        mEditNamaDesa = findViewById(R.id.editTextNamaDesa);
        mEditJumlahPenduduk = findViewById(R.id.editTextJumlahPenduduk);
        mEditIbuHamil = findViewById(R.id.editTextIbuHamil);
        mEditBayi = findViewById(R.id.editTextBayi);
        mEditBalita = findViewById(R.id.editTextBalita);
        mEditReseptifitas = findViewById(R.id.switchReseptifitas);
        mEditReseptifitasTanggal = findViewById(R.id.editTextTanggalResp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(mEditKodeDesa.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String kodeDesa = mEditKodeDesa.getText().toString();
            String namaDesa = mEditNamaDesa.getText().toString();
            String jumlahPenduduk = mEditJumlahPenduduk.getText().toString();
            String ibuHamil = mEditIbuHamil.getText().toString();
            String bayi = mEditBayi.getText().toString();
            String balita = mEditBalita.getText().toString();
            String reseptifitas = mEditReseptifitas.getText().toString();
            String reseptifitasTanggal = mEditReseptifitasTanggal.getText().toString();
            replyIntent.putExtra(EXTRA_KODE_DESA, kodeDesa);
            replyIntent.putExtra(EXTRA_NAMA_DESA, namaDesa);
            replyIntent.putExtra(EXTRA_JUMLAHPENDUDUK, jumlahPenduduk);
            replyIntent.putExtra(EXTRA_IBUHAMIL, ibuHamil);
            replyIntent.putExtra(EXTRA_BAYI, bayi);
            replyIntent.putExtra(EXTRA_BALITA, balita);
            replyIntent.putExtra(EXTRA_RESEPTIFITAS, reseptifitas);
            replyIntent.putExtra(EXTRA_RESEPTIFITASTANGGAL, reseptifitasTanggal);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
        return true;
    }

    public void showDatePicker(View view) {
//        if (view.getId() == R.id.buttonTanggalKunjungan)
            datePickerIdx = 1;
//        else if (view.getId() == R.id.buttonTanggalPE)
//            datePickerIdx = 2;
//        else
//            datePickerIdx = 0;
        DialogFragment newFragment = new DesaDatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day, int idx) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string +
                "/" + month_string + "/" + year_string);
//        if (idx == 1)
//            mTanggalKunjugan.setText(dateMessage);
//        else
            mEditReseptifitasTanggal.setText(dateMessage);
    }
}