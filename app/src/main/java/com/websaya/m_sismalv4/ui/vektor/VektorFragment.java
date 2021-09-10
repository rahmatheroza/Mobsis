package com.websaya.m_sismalv4.ui.vektor;

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

public class VektorFragment extends Fragment {
    private RecyclerView recyclerView;
    private VektorViewModel mVektorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.regmal1_list_fragment, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getContext(), VektorInputActivity.class);
                getActivity().startActivityForResult(intent, MainActivity.NEW_VEKTOR_ACTIVITY_REQUEST_CODE);
            }
        });

        recyclerView = root.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // specify an adapter (see also next example)
        final VektorListAdapter mAdapter = new VektorListAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        mVektorViewModel = ViewModelProviders.of(this).get(VektorViewModel.class);
        mVektorViewModel.getAllData().observe(getActivity(), new Observer<List<Vektor>>() {
            @Override
            public void onChanged(@Nullable final List<Vektor> vektors) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setData(vektors);
            }
        });
        return root;
    }
}