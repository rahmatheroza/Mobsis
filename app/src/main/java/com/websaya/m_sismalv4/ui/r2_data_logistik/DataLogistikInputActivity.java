package com.websaya.m_sismalv4.ui.r2_data_logistik;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.websaya.m_sismalv4.R;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1DatePickerFragment;

public class DataLogistikInputActivity extends AppCompatActivity {

    public static final String EXTRA_DESA_PASIEN = "EXTRA_DESA_PASIEN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
    private EditText mEditNamaPasien;
    private EditText mEditDesaPasien;
    public int datePickerIdx;
    EditText mTanggalEDTerdekat1;
    EditText mTanggalEDTerdekat2;
    EditText mTanggalEDTerdekat3;
    EditText mTanggalEDTerdekat4;
    EditText mTanggalEDTerdekat5;
    EditText mTanggalEDTerdekat6;
    EditText mTanggalEDTerdekat7;
    EditText mTanggalEDTerdekat8;
    EditText mTanggalEDTerdekat9;
    EditText mTanggalEDTerdekat10;
    EditText mTanggalEDTerdekat11;
    EditText mTanggalEDTerdekat12;
    EditText mTanggalEDTerdekat13;
    Spinner mSpinnerBulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_logistik_form);
        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
        mEditDesaPasien = findViewById(R.id.editTextDesaPasien);
        mTanggalEDTerdekat1 = findViewById(R.id.editTextTanggalEDTerdekat1);
        mTanggalEDTerdekat2 = findViewById(R.id.editTextTanggalEDTerdekat2);
        mTanggalEDTerdekat3 = findViewById(R.id.editTextTanggalEDTerdekat3);
        mTanggalEDTerdekat4 = findViewById(R.id.editTextTanggalEDTerdekat4);
        mTanggalEDTerdekat5 = findViewById(R.id.editTextTanggalEDTerdekat5);
        mTanggalEDTerdekat6 = findViewById(R.id.editTextTanggalEDTerdekat6);
        mTanggalEDTerdekat7 = findViewById(R.id.editTextTanggalEDTerdekat7);
        mTanggalEDTerdekat8 = findViewById(R.id.editTextTanggalEDTerdekat8);
        mTanggalEDTerdekat9 = findViewById(R.id.editTextTanggalEDTerdekat9);
        mTanggalEDTerdekat10 = findViewById(R.id.editTextTanggalEDTerdekat10);
        mTanggalEDTerdekat11 = findViewById(R.id.editTextTanggalEDTerdekat11);
        mTanggalEDTerdekat12 = findViewById(R.id.editTextTanggalEDTerdekat12);
        mTanggalEDTerdekat13 = findViewById(R.id.editTextTanggalEDTerdekat13);

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
            String namaPasien = mSpinnerBulan.getSelectedItem().toString();
            String desaPasien = "";
            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA_PASIEN, desaPasien);
            setResult(RESULT_OK, replyIntent);
//        }
        finish();
        return true;
    }

    public void showDatePicker(View view) {
        if (view.getId() == R.id.buttonTanggalEDTerdekat1)
            datePickerIdx = 1;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat2)
            datePickerIdx = 2;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat3)
            datePickerIdx = 3;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat4)
            datePickerIdx = 4;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat5)
            datePickerIdx = 5;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat6)
            datePickerIdx = 6;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat7)
            datePickerIdx = 7;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat8)
            datePickerIdx = 8;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat9)
            datePickerIdx = 9;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat10)
            datePickerIdx = 10;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat11)
            datePickerIdx = 11;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat12)
            datePickerIdx = 12;
        else if (view.getId() == R.id.buttonTanggalEDTerdekat13)
            datePickerIdx = 13;
        else
            datePickerIdx = 0;
        DialogFragment newFragment = new DataLogistikDatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day, int idx) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string +
                "/" + month_string + "/" + year_string);
        if (idx == 1)
            mTanggalEDTerdekat1.setText(dateMessage);
        else if (idx == 2)
            mTanggalEDTerdekat2.setText(dateMessage);
        else if (idx == 3)
            mTanggalEDTerdekat3.setText(dateMessage);
        else if (idx == 4)
            mTanggalEDTerdekat4.setText(dateMessage);
        else if (idx == 5)
            mTanggalEDTerdekat5.setText(dateMessage);
        else if (idx == 6)
            mTanggalEDTerdekat6.setText(dateMessage);
        else if (idx == 7)
            mTanggalEDTerdekat7.setText(dateMessage);
        else if (idx == 8)
            mTanggalEDTerdekat8.setText(dateMessage);
        else if (idx == 9)
            mTanggalEDTerdekat9.setText(dateMessage);
        else if (idx == 10)
            mTanggalEDTerdekat10.setText(dateMessage);
        else if (idx == 11)
            mTanggalEDTerdekat11.setText(dateMessage);
        else if (idx == 12)
            mTanggalEDTerdekat12.setText(dateMessage);
        else if (idx == 13)
            mTanggalEDTerdekat13.setText(dateMessage);
    }
}