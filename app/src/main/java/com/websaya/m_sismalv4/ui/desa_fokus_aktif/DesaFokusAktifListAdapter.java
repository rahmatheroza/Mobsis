package com.websaya.m_sismalv4.ui.desa_fokus_aktif;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class DesaFokusAktifListAdapter extends RecyclerView.Adapter<DesaFokusAktifListAdapter.FokusAktifViewHolder> {
    private final LayoutInflater mInflater;
    private List<DesaFokusAktif> mDesaFokusAktif; // Cached copy of words

    public DesaFokusAktifListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public FokusAktifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new FokusAktifViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FokusAktifViewHolder holder, int position) {
        if (mDesaFokusAktif != null) {
            DesaFokusAktif current = mDesaFokusAktif.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<DesaFokusAktif> desaFokusAktifs){
        mDesaFokusAktif = desaFokusAktifs;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDesaFokusAktif != null)
            return mDesaFokusAktif.size();
        else return 0;
    }

    class FokusAktifViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private FokusAktifViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
