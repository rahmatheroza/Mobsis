package com.websaya.m_sismalv4.ui.desa;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.websaya.m_sismalv4.MainActivity;
import com.websaya.m_sismalv4.R;

import java.util.List;

public class DesaFragment extends Fragment {
    private RecyclerView recyclerView;
    private DesaViewModel mDesaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.desa_list_fragment, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getContext(), InputDesaActivity.class);
                getActivity().startActivityForResult(intent, MainActivity.NEW_DESA_ACTIVITY_REQUEST_CODE);
            }
        });

        recyclerView = root.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // specify an adapter (see also next example)
        final DesaListAdapter mAdapter = new DesaListAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        mDesaViewModel = ViewModelProviders.of(this).get(DesaViewModel.class);
        mDesaViewModel.getAllDesa().observe(getActivity(), new Observer<List<Desa>>() {
            @Override
            public void onChanged(@Nullable final List<Desa> desas) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setDesa(desas);
            }
        });
        return root;
    }
}