package com.websaya.m_sismalv4.ui.desa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.websaya.m_sismalv4.R;

import java.util.List;

public class DesaListAdapter extends RecyclerView.Adapter<DesaListAdapter.DesaViewHolder> {
    private final LayoutInflater mInflater;
    private List<Desa> mDesa; // Cached copy of words

    public DesaListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public DesaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.desa_list_item, parent, false);
        return new DesaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DesaViewHolder holder, int position) {
        if (mDesa != null) {
            Desa current = mDesa.get(position);
            holder.kodeItemView.setText(current.getKode());
            holder.namaItemView.setText(current.getNama());
            holder.jumlahPendudukItemView.setText(current.getJumlahPenduduk());
            holder.ibuHamilItemView.setText(current.getIbuHamil());
            holder.bayiItemView.setText(current.getBayi());
            holder.balitaItemView.setText(current.getBalita());
//            holder.reseptifitasItemView.setText(current.getReseptifitas());
            holder.reseptifitasTanggalItemView.setText(current.getReseptifitasTanggal());
        } else {
            // Covers the case of data not being ready yet.
            holder.kodeItemView.setText("-");
            holder.namaItemView.setText("-");
            holder.jumlahPendudukItemView.setText("-");
            holder.ibuHamilItemView.setText("-");
            holder.bayiItemView.setText("-");
            holder.balitaItemView.setText("-");
//            holder.reseptifitasItemView.setText("-");
            holder.reseptifitasTanggalItemView.setText("-");
        }
    }

    public void setDesa(List<Desa> desas){
        mDesa = desas;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mDesa != null)
            return mDesa.size();
        else return 0;
    }

    class DesaViewHolder extends RecyclerView.ViewHolder {
        private final TextView kodeItemView;
        private final TextView namaItemView;
        private final TextView jumlahPendudukItemView;
        private final TextView ibuHamilItemView;
        private final TextView bayiItemView;
        private final TextView balitaItemView;
//        private final TextView reseptifitasItemView;
        private final TextView reseptifitasTanggalItemView;

        private DesaViewHolder(View itemView) {
            super(itemView);
            kodeItemView = itemView.findViewById(R.id.kodeDesa);
            namaItemView = itemView.findViewById(R.id.namaDesa);
            jumlahPendudukItemView = itemView.findViewById(R.id.jumlahPenduduk);
            ibuHamilItemView = itemView.findViewById(R.id.ibuHamil);
            bayiItemView = itemView.findViewById(R.id.bayi);
            balitaItemView = itemView.findViewById(R.id.balita);
            //reseptifitasItemView = itemView.findViewById(R.id.reseptifitas);
            reseptifitasTanggalItemView = itemView.findViewById(R.id.reseptifitasTanggal);
        }
    }
}
