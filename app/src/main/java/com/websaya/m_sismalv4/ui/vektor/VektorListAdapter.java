package com.websaya.m_sismalv4.ui.vektor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.websaya.m_sismalv4.R;

import java.util.List;

public class VektorListAdapter extends RecyclerView.Adapter<VektorListAdapter.VektorViewHolder> {
    private final LayoutInflater mInflater;
    private List<Vektor> mVektor; // Cached copy of words

    public VektorListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public VektorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.regmal1_list_item, parent, false);
        return new VektorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VektorViewHolder holder, int position) {
        if (mVektor != null) {
            Vektor current = mVektor.get(position);
            holder.namaPasienItemView.setText(current.getNama());
            holder.desaPasienItemView.setText(current.getDesa());
        } else {
            // Covers the case of data not being ready yet.
            holder.namaPasienItemView.setText("Nama Pasien");
            holder.desaPasienItemView.setText("Desa Pasien");
        }
    }

    public void setData(List<Vektor> vektors){
        mVektor = vektors;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mVektor != null)
            return mVektor.size();
        else return 0;
    }

    class VektorViewHolder extends RecyclerView.ViewHolder {
        private final TextView namaPasienItemView;
        private final TextView desaPasienItemView;

        private VektorViewHolder(View itemView) {
            super(itemView);
            namaPasienItemView = itemView.findViewById(R.id.namaPasien);
            desaPasienItemView = itemView.findViewById(R.id.desaPasien);
        }
    }
}
