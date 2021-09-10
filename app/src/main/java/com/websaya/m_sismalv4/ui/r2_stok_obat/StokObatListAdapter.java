package com.websaya.m_sismalv4.ui.r2_stok_obat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class StokObatListAdapter extends RecyclerView.Adapter<StokObatListAdapter.StokObatViewHolder> {
    private final LayoutInflater mInflater;
    private List<StokObat> mStokObat; // Cached copy of words

    public StokObatListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public StokObatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new StokObatViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StokObatViewHolder holder, int position) {
        if (mStokObat != null) {
            StokObat current = mStokObat.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<StokObat> stokObats){
        mStokObat = stokObats;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mStokObat != null)
            return mStokObat.size();
        else return 0;
    }

    class StokObatViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private StokObatViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
