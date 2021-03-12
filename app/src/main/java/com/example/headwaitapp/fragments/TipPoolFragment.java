package com.example.headwaitapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.headwaitapp.R;
import com.example.headwaitapp.adapters.TipPoolAdapter;
import com.example.headwaitapp.appclasses.Headwait;

public class TipPoolFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private RecyclerView recyclerView;
    private TipPoolAdapter adapter;

    public TipPoolFragment() {
        // Required empty public constructor
    }

    public static TipPoolFragment newInstance() {
        TipPoolFragment fragment = new TipPoolFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        manuel = TipPoolFragmentArgs.fromBundle(getArguments()).getHeadWait();
        navController = Navigation.findNavController(view);

        recyclerView = view.findViewById(R.id.TP_RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new TipPoolAdapter(manuel.getServers());
        recyclerView.setAdapter(adapter);

        view.findViewById(R.id.FTP_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipPoolFragmentDirections.ActionTipPoolFragmentToServersFragment action =
                        TipPoolFragmentDirections.actionTipPoolFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip_pool, container, false);
    }
}