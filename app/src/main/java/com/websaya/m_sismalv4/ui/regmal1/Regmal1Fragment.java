package com.websaya.m_sismalv4.ui.regmal1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

public class Regmal1Fragment extends Fragment {
    private RecyclerView recyclerView;
    private Regmal1ViewModel mRegmal1ViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.regmal1_list_fragment, container, false);

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(getContext(), Regmal1InputActivity.class);
                getActivity().startActivityForResult(intent, MainActivity.NEW_REGMAL1_ACTIVITY_REQUEST_CODE);
            }
        });

        recyclerView = root.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // specify an adapter (see also next example)
        final Regmal1ListAdapter mAdapter = new Regmal1ListAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        mRegmal1ViewModel = ViewModelProviders.of(this).get(Regmal1ViewModel.class);
        mRegmal1ViewModel.getAllRegmal1().observe(getActivity(), new Observer<List<Regmal1>>() {
            @Override
            public void onChanged(@Nullable final List<Regmal1> regmal1s) {
                // Update the cached copy of the words in the adapter.
                mAdapter.setData(regmal1s);
            }
        });
        return root;
    }
}