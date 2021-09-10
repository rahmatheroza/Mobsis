package com.websaya.m_sismalv4.ui.regmal1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class Regmal1ListAdapter extends RecyclerView.Adapter<Regmal1ListAdapter.Regmal1ViewHolder> {
    private final LayoutInflater mInflater;
    private List<Regmal1> mRegmal1; // Cached copy of words

    public Regmal1ListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public Regmal1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new Regmal1ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Regmal1ViewHolder holder, int position) {
        if (mRegmal1 != null) {
            Regmal1 current = mRegmal1.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<Regmal1> regmal1s){
        mRegmal1 = regmal1s;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mRegmal1 != null)
            return mRegmal1.size();
        else return 0;
    }

    class Regmal1ViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private Regmal1ViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
