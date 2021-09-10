package com.websaya.m_sismalv4.ui.regmal1;

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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.websaya.m_sismalv4.R;
import com.websaya.m_sismalv4.ui.desa.Desa;
import com.websaya.m_sismalv4.ui.desa.DesaViewModel;

import java.util.ArrayList;
import java.util.List;

public class Regmal1InputActivity extends AppCompatActivity{

    public static final String EXTRA_DESA_PASIEN = "EXTRA_DESA_PASIEN";
    public static final String EXTRA_NAMA_PASIEN = "EXTRA_NAMA_PASIEN";
    public int datePickerIdx;
    private EditText mEditNamaPasien;
    EditText mTanggalKunjugan;
    EditText mTanggalPE;
    Spinner mSpinnerDesa;
//    private EditText mEditDesaPasien;

    private DesaViewModel mDesaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regmal1_form);
        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
        mTanggalKunjugan = findViewById(R.id.editTextTanggalKunjugan);
        mTanggalPE = findViewById(R.id.editTextTanggalPE);
        //mEditDesaPasien = findViewById(R.id.editTextDesaPasien);

        Spinner spinnerJenisKegiatanPenemuan = (Spinner) findViewById(R.id.spinnerJenisKegiatanPenemuan);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jenisKegiatanPenemuan_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisKegiatanPenemuan.setAdapter(adapter);

        mSpinnerDesa = (Spinner) findViewById(R.id.spinnerDesa);
        Spinner spinner22 = (Spinner) findViewById(R.id.spinnerDesaPE);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerDesa.setAdapter(adapter2);
        spinner22.setAdapter(adapter2);
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

        Spinner spinner3 = (Spinner) findViewById(R.id.spinnerPekerjaan);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.pekerjaan_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinnerJenisParasit);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.jenisParasit_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        Spinner spinner5 = (Spinner) findViewById(R.id.spinnerFaskes);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.faskes_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
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
            String desaPasien = mSpinnerDesa.getSelectedItem().toString();
            replyIntent.putExtra(EXTRA_NAMA_PASIEN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA_PASIEN, desaPasien);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
        return true;
    }

    public void showDatePicker(View view) {
        if (view.getId() == R.id.buttonTanggalKunjungan)
            datePickerIdx = 1;
        else if (view.getId() == R.id.buttonTanggalPE)
            datePickerIdx = 2;
        else
            datePickerIdx = 0;
        DialogFragment newFragment = new Regmal1DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    public void processDatePickerResult(int year, int month, int day, int idx) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (day_string +
                "/" + month_string + "/" + year_string);
        if (idx == 1)
            mTanggalKunjugan.setText(dateMessage);
        else
            mTanggalPE.setText(dateMessage);
    }
}