package com.websaya.m_sismalv4.ui.r2_data_penemuan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class DataPenemuanListAdapter extends RecyclerView.Adapter<DataPenemuanListAdapter.DataPenemuanViewHolder> {
    private final LayoutInflater mInflater;
    private List<DataPenemuan> mDataPenemuan; // Cached copy of words

    public DataPenemuanListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DataPenemuanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new DataPenemuanViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataPenemuanViewHolder holder, int position) {
        if (mDataPenemuan != null) {
            DataPenemuan current = mDataPenemuan.get(position);
            holder.namaPasienItemView.setText(current.getBulan());
            holder.desaPasienItemView.setText("Jumlah Suspek Malaria (PCD): 0");
        } else {
            // Covers the case of data not being ready yet.
//            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<DataPenemuan> dataPenemuans){
        mDataPenemuan = dataPenemuans;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDataPenemuan != null)
            return mDataPenemuan.size();
        else return 0;
    }

    class DataPenemuanViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private DataPenemuanViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
