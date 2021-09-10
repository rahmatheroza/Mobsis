package com.websaya.m_sismalv4.ui.r2_data_uji_silang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class DataUjiSilangListAdapter extends RecyclerView.Adapter<DataUjiSilangListAdapter.DataUjiSilangViewHolder> {
    private final LayoutInflater mInflater;
    private List<DataUjiSilang> mDataUjiSilang; // Cached copy of words

    public DataUjiSilangListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DataUjiSilangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new DataUjiSilangViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataUjiSilangViewHolder holder, int position) {
        if (mDataUjiSilang != null) {
            DataUjiSilang current = mDataUjiSilang.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<DataUjiSilang> dataUjiSilangs){
        mDataUjiSilang = dataUjiSilangs;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDataUjiSilang != null)
            return mDataUjiSilang.size();
        else return 0;
    }

    class DataUjiSilangViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private DataUjiSilangViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
