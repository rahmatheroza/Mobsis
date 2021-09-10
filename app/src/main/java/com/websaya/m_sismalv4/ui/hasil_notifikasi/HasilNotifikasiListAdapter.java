package com.websaya.m_sismalv4.ui.hasil_notifikasi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class HasilNotifikasiListAdapter extends RecyclerView.Adapter<HasilNotifikasiListAdapter.HasilNotifikasiViewHolder> {
    private final LayoutInflater mInflater;
    private List<HasilNotifikasi> mHasilNotifikasi; // Cached copy of words

    public HasilNotifikasiListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public HasilNotifikasiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new HasilNotifikasiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HasilNotifikasiViewHolder holder, int position) {
        if (mHasilNotifikasi != null) {
            HasilNotifikasi current = mHasilNotifikasi.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<HasilNotifikasi> hasilNotifikasis){
        mHasilNotifikasi = hasilNotifikasis;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mHasilNotifikasi != null)
            return mHasilNotifikasi.size();
        else return 0;
    }

    class HasilNotifikasiViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private HasilNotifikasiViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
