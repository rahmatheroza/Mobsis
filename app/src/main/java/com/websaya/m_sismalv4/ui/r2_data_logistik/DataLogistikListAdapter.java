package com.websaya.m_sismalv4.ui.r2_data_logistik;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class DataLogistikListAdapter extends RecyclerView.Adapter<DataLogistikListAdapter.DataLogistikViewHolder> {
    private final LayoutInflater mInflater;
    private List<DataLogistik> mDataLogistik; // Cached copy of words

    public DataLogistikListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DataLogistikViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new DataLogistikViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataLogistikViewHolder holder, int position) {
        if (mDataLogistik != null) {
            DataLogistik current = mDataLogistik.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<DataLogistik> dataLogistiks){
        mDataLogistik = dataLogistiks;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDataLogistik != null)
            return mDataLogistik.size();
        else return 0;
    }

    class DataLogistikViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private DataLogistikViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
