package com.websaya.m_sismalv4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.websaya.m_sismalv4.ui.desa.Desa;
import com.websaya.m_sismalv4.ui.desa.DesaListAdapter;
import com.websaya.m_sismalv4.ui.desa.DesaViewModel;
import com.websaya.m_sismalv4.ui.desa.InputDesaActivity;
import com.websaya.m_sismalv4.ui.desa_fokus_aktif.DesaFokusAktif;
import com.websaya.m_sismalv4.ui.desa_fokus_aktif.DesaFokusAktifInputActivity;
import com.websaya.m_sismalv4.ui.desa_fokus_aktif.DesaFokusAktifListAdapter;
import com.websaya.m_sismalv4.ui.desa_fokus_aktif.DesaFokusAktifViewModel;
import com.websaya.m_sismalv4.ui.fokus_aktif.FokusAktif;
import com.websaya.m_sismalv4.ui.fokus_aktif.FokusAktifInputActivity;
import com.websaya.m_sismalv4.ui.fokus_aktif.FokusAktifListAdapter;
import com.websaya.m_sismalv4.ui.fokus_aktif.FokusAktifViewModel;
import com.websaya.m_sismalv4.ui.hasil_notifikasi.HasilNotifikasi;
import com.websaya.m_sismalv4.ui.hasil_notifikasi.HasilNotifikasiInputActivity;
import com.websaya.m_sismalv4.ui.hasil_notifikasi.HasilNotifikasiListAdapter;
import com.websaya.m_sismalv4.ui.hasil_notifikasi.HasilNotifikasiViewModel;
import com.websaya.m_sismalv4.ui.r2_data_logistik.DataLogistik;
import com.websaya.m_sismalv4.ui.r2_data_logistik.DataLogistikInputActivity;
import com.websaya.m_sismalv4.ui.r2_data_logistik.DataLogistikListAdapter;
import com.websaya.m_sismalv4.ui.r2_data_logistik.DataLogistikViewModel;
import com.websaya.m_sismalv4.ui.r2_data_penemuan.DataPenemuan;
import com.websaya.m_sismalv4.ui.r2_data_penemuan.DataPenemuanInputActivity;
import com.websaya.m_sismalv4.ui.r2_data_penemuan.DataPenemuanListAdapter;
import com.websaya.m_sismalv4.ui.r2_data_penemuan.DataPenemuanViewModel;
import com.websaya.m_sismalv4.ui.r2_data_uji_silang.DataUjiSilang;
import com.websaya.m_sismalv4.ui.r2_data_uji_silang.DataUjiSilangInputActivity;
import com.websaya.m_sismalv4.ui.r2_data_uji_silang.DataUjiSilangListAdapter;
import com.websaya.m_sismalv4.ui.r2_data_uji_silang.DataUjiSilangViewModel;
import com.websaya.m_sismalv4.ui.r2_stok_obat.StokObat;
import com.websaya.m_sismalv4.ui.r2_stok_obat.StokObatInputActivity;
import com.websaya.m_sismalv4.ui.r2_stok_obat.StokObatListAdapter;
import com.websaya.m_sismalv4.ui.r2_stok_obat.StokObatViewModel;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1InputActivity;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1ListAdapter;
import com.websaya.m_sismalv4.ui.regmal1.Regmal1ViewModel;
import com.websaya.m_sismalv4.ui.vektor.Vektor;
import com.websaya.m_sismalv4.ui.vektor.VektorInputActivity;
import com.websaya.m_sismalv4.ui.vektor.VektorListAdapter;
import com.websaya.m_sismalv4.ui.vektor.VektorViewModel;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int UPDATE_INFO_KUNCI_ACTIVITY_REQUEST_CODE = 1;
    public static final int NEW_DESA_ACTIVITY_REQUEST_CODE = 2;
    public static final int NEW_REGMAL1_ACTIVITY_REQUEST_CODE = 3;
    public static final int NEW_DATA_PENEMUAN_ACTIVITY_REQUEST_CODE = 4;
    public static final int NEW_DATA_LOGISTIK_ACTIVITY_REQUEST_CODE = 5;
    public static final int NEW_STOK_OBAT_ACTIVITY_REQUEST_CODE = 6;
    public static final int NEW_DATA_UJI_SILANG_ACTIVITY_REQUEST_CODE = 7;
    public static final int NEW_VEKTOR_ACTIVITY_REQUEST_CODE = 8;
    public static final int NEW_DESA_FOKUS_AKTIF_ACTIVITY_REQUEST_CODE = 11;
    public static final int NEW_FOKUS_AKTIF_ACTIVITY_REQUEST_CODE = 9;
    public static final int NEW_HASIL_NOTIFIKASI_ACTIVITY_REQUEST_CODE = 10;
    private AppBarConfiguration mAppBarConfiguration;
    private DesaViewModel mDesaViewModel;
    private Regmal1ViewModel mRegmal1ViewModel;
    private DataPenemuanViewModel mDataPenemuanViewModel;
    private DataLogistikViewModel mDataLogistikViewModel;
    private StokObatViewModel mStokObatViewModel;
    private DataUjiSilangViewModel mDataUjiSilangViewModel;
    private VektorViewModel mVektorViewModel;
    private DesaFokusAktifViewModel mDesaFokusAktifViewModel;
    private FokusAktifViewModel mFokusAktifViewModel;
    private HasilNotifikasiViewModel mHasilNotifikasiViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DesaListAdapter desaListAdapter = new DesaListAdapter(this);

        mDesaViewModel = ViewModelProviders.of(this).get(DesaViewModel.class);
        mDesaViewModel.getAllDesa().observe(this, new Observer<List<Desa>>() {
            @Override
            public void onChanged(@Nullable final List<Desa> desas) {
                // Update the cached copy of the words in the adapter.
                desaListAdapter.setDesa(desas);
            }
        });

        final Regmal1ListAdapter regmal1ListAdapter = new Regmal1ListAdapter(this);

        mRegmal1ViewModel = ViewModelProviders.of(this).get(Regmal1ViewModel.class);
        mRegmal1ViewModel.getAllRegmal1().observe(this, new Observer<List<Regmal1>>() {
            @Override
            public void onChanged(@Nullable final List<Regmal1> regmal1s) {
                // Update the cached copy of the words in the adapter.
                regmal1ListAdapter.setData(regmal1s);
            }
        });

        final DataPenemuanListAdapter dataPenemuanListAdapter = new DataPenemuanListAdapter(this);

        mDataPenemuanViewModel = ViewModelProviders.of(this).get(DataPenemuanViewModel.class);
        mDataPenemuanViewModel.getAllData().observe(this, new Observer<List<DataPenemuan>>() {
            @Override
            public void onChanged(@Nullable final List<DataPenemuan> data) {
                // Update the cached copy of the words in the adapter.
                dataPenemuanListAdapter.setData(data);
            }
        });

        final DataLogistikListAdapter dataLogistikListAdapter = new DataLogistikListAdapter(this);

        mDataLogistikViewModel = ViewModelProviders.of(this).get(DataLogistikViewModel.class);
        mDataLogistikViewModel.getAllData().observe(this, new Observer<List<DataLogistik>>() {
            @Override
            public void onChanged(@Nullable final List<DataLogistik> data) {
                // Update the cached copy of the words in the adapter.
                dataLogistikListAdapter.setData(data);
            }
        });

        final StokObatListAdapter stokObatListAdapter = new StokObatListAdapter(this);

        mStokObatViewModel = ViewModelProviders.of(this).get(StokObatViewModel.class);
        mStokObatViewModel.getAllData().observe(this, new Observer<List<StokObat>>() {
            @Override
            public void onChanged(@Nullable final List<StokObat> data) {
                // Update the cached copy of the words in the adapter.
                stokObatListAdapter.setData(data);
            }
        });

        final DataUjiSilangListAdapter dataUjiSilangListAdapter = new DataUjiSilangListAdapter(this);

        mDataUjiSilangViewModel = ViewModelProviders.of(this).get(DataUjiSilangViewModel.class);
        mDataUjiSilangViewModel.getAllData().observe(this, new Observer<List<DataUjiSilang>>() {
            @Override
            public void onChanged(@Nullable final List<DataUjiSilang> data) {
                // Update the cached copy of the words in the adapter.
                dataUjiSilangListAdapter.setData(data);
            }
        });

        final VektorListAdapter vektorListAdapter = new VektorListAdapter(this);

        mVektorViewModel = ViewModelProviders.of(this).get(VektorViewModel.class);
        mVektorViewModel.getAllData().observe(this, new Observer<List<Vektor>>() {
            @Override
            public void onChanged(@Nullable final List<Vektor> data) {
                // Update the cached copy of the words in the adapter.
                vektorListAdapter.setData(data);
            }
        });

        final FokusAktifListAdapter fokusAktifListAdapter = new FokusAktifListAdapter(this);

        mFokusAktifViewModel = ViewModelProviders.of(this).get(FokusAktifViewModel.class);
        mFokusAktifViewModel.getAllData().observe(this, new Observer<List<FokusAktif>>() {
            @Override
            public void onChanged(@Nullable final List<FokusAktif> data) {
                // Update the cached copy of the words in the adapter.
                fokusAktifListAdapter.setData(data);
            }
        });

        final DesaFokusAktifListAdapter desaFokusAktifListAdapter = new DesaFokusAktifListAdapter(this);

        mDesaFokusAktifViewModel = ViewModelProviders.of(this).get(DesaFokusAktifViewModel.class);
        mDesaFokusAktifViewModel.getAllData().observe(this, new Observer<List<DesaFokusAktif>>() {
            @Override
            public void onChanged(@Nullable final List<DesaFokusAktif> data) {
                // Update the cached copy of the words in the adapter.
                desaFokusAktifListAdapter.setData(data);
            }
        });

        final HasilNotifikasiListAdapter hasilNotifikasiListAdapter = new HasilNotifikasiListAdapter(this);

        mHasilNotifikasiViewModel = ViewModelProviders.of(this).get(HasilNotifikasiViewModel.class);
        mHasilNotifikasiViewModel.getAllData().observe(this, new Observer<List<HasilNotifikasi>>() {
            @Override
            public void onChanged(@Nullable final List<HasilNotifikasi> data) {
                // Update the cached copy of the words in the adapter.
                hasilNotifikasiListAdapter.setData(data);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_desa, R.id.nav_info_kunci, R.id.nav_regmal_1, R.id.nav_data_penemuan, R.id.nav_data_logistik, R.id.nav_stok_obat, R.id.nav_vektor, R.id.nav_desa_fokus_aktif, R.id.nav_fokus_aktif, R.id.nav_kasus_indigenous)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_DESA_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Desa desa = new Desa(0,data.getStringExtra(InputDesaActivity.EXTRA_KODE_DESA), data.getStringExtra(InputDesaActivity.EXTRA_NAMA_DESA), data.getStringExtra(InputDesaActivity.EXTRA_JUMLAHPENDUDUK), data.getStringExtra(InputDesaActivity.EXTRA_IBUHAMIL), data.getStringExtra(InputDesaActivity.EXTRA_BAYI), data.getStringExtra(InputDesaActivity.EXTRA_BALITA), data.getStringExtra(InputDesaActivity.EXTRA_RESEPTIFITAS), data.getStringExtra(InputDesaActivity.EXTRA_RESEPTIFITASTANGGAL));
            mDesaViewModel.insert(desa);
        } else if (requestCode == NEW_REGMAL1_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Regmal1 regmal1 = new Regmal1(0,data.getStringExtra(Regmal1InputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(Regmal1InputActivity.EXTRA_DESA_PASIEN));
            mRegmal1ViewModel.insert(regmal1);
        }  else if (requestCode == NEW_DATA_PENEMUAN_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DataPenemuan dataPenemuan = new DataPenemuan(0,data.getStringExtra(DataPenemuanInputActivity.EXTRA_BULAN));
            mDataPenemuanViewModel.insert(dataPenemuan);
        }  else if (requestCode == NEW_DATA_LOGISTIK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DataLogistik dataLogistik = new DataLogistik(0,data.getStringExtra(DataLogistikInputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(DataLogistikInputActivity.EXTRA_DESA_PASIEN));
            mDataLogistikViewModel.insert(dataLogistik);
        }  else if (requestCode == NEW_STOK_OBAT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            StokObat stokObat = new StokObat(0,data.getStringExtra(StokObatInputActivity.EXTRA_BULAN), data.getStringExtra(StokObatInputActivity.EXTRA_DESA_PASIEN));
            mStokObatViewModel.insert(stokObat);
        }  else if (requestCode == NEW_DATA_UJI_SILANG_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DataUjiSilang dataUjiSilang = new DataUjiSilang(0,data.getStringExtra(DataUjiSilangInputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(DataUjiSilangInputActivity.EXTRA_DESA_PASIEN));
            mDataUjiSilangViewModel.insert(dataUjiSilang);
        }  else if (requestCode == NEW_VEKTOR_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Vektor vektor = new Vektor(0,data.getStringExtra(VektorInputActivity.EXTRA_BULAN), data.getStringExtra(VektorInputActivity.EXTRA_DESA));
            mVektorViewModel.insert(vektor);
        }  else if (requestCode == NEW_DESA_FOKUS_AKTIF_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            DesaFokusAktif desaFokusAktif = new DesaFokusAktif(0,data.getStringExtra(DesaFokusAktifInputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(DesaFokusAktifInputActivity.EXTRA_DESA_PASIEN));
            mDesaFokusAktifViewModel.insert(desaFokusAktif);
        }  else if (requestCode == NEW_FOKUS_AKTIF_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            FokusAktif fokusAktif = new FokusAktif(0,data.getStringExtra(FokusAktifInputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(FokusAktifInputActivity.EXTRA_DESA_PASIEN));
            mFokusAktifViewModel.insert(fokusAktif);
        }  else if (requestCode == NEW_HASIL_NOTIFIKASI_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            HasilNotifikasi hasilNotifikasi = new HasilNotifikasi(0,data.getStringExtra(HasilNotifikasiInputActivity.EXTRA_NAMA_PASIEN), data.getStringExtra(HasilNotifikasiInputActivity.EXTRA_DESA_PASIEN));
            mHasilNotifikasiViewModel.insert(hasilNotifikasi);
        }  else if(requestCode == UPDATE_INFO_KUNCI_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(
                    getApplicationContext(),
                    "Update berhasil.",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_SHORT).show();
        }
    }
}