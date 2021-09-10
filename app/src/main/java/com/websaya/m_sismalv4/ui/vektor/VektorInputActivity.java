package com.websaya.m_sismalv4.ui.vektor;

import android.content.Intent;
import android.os.Bundle;
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

public class VektorInputActivity extends AppCompatActivity {

    public static final String EXTRA_DESA = "EXTRA_DESA";
    public static final String EXTRA_BULAN = "EXTRA_BULAN";
//    private EditText mEditNamaPasien;
//    private EditText mEditDesa;
    Spinner mSpinnerBulan;
    Spinner mSpinnerDesa;
    private DesaViewModel mDesaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vektor_form);
//        mEditNamaPasien = findViewById(R.id.editTextNamaPasien);
//        mEditDesa = findViewById(R.id.editTextDesaPasien);

        mSpinnerBulan = (Spinner) findViewById(R.id.spinnerBulan);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.bulan_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerBulan.setAdapter(adapter1);

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

        Spinner spinner3 = (Spinner) findViewById(R.id.spinnerJenisInsektisida1);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinnerJenisInsektisida2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.jenisInsektisida_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter3);

        Spinner spinner5 = (Spinner) findViewById(R.id.spinnerJenisLarvasida1);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinnerJenisLarvasida2);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.jenisLarvasida_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner6.setAdapter(adapter5);

        Spinner spinner7 = (Spinner) findViewById(R.id.spinnerJenisVektor1);
        Spinner spinner8 = (Spinner) findViewById(R.id.spinnerJenisVektor2);
        Spinner spinner9 = (Spinner) findViewById(R.id.spinnerJenisVektor3);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this,
                R.array.jenisVektor_array, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);
        spinner8.setAdapter(adapter7);
        spinner9.setAdapter(adapter7);

        Spinner spinner10 = (Spinner) findViewById(R.id.spinnerJumlahTempatPerindukan);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this,
                R.array.jumlahTempatPerindukan_array, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner10.setAdapter(adapter10);
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
            String desaPasien = mSpinnerDesa.getSelectedItem().toString();
            replyIntent.putExtra(EXTRA_BULAN, namaPasien);
            replyIntent.putExtra(EXTRA_DESA, desaPasien);
            setResult(RESULT_OK, replyIntent);
//        }
        finish();
        return true;
    }
}