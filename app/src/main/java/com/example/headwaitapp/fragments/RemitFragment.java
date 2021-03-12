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
import android.widget.TextView;

import com.example.headwaitapp.R;
import com.example.headwaitapp.adapters.RemitAdapter;
import com.example.headwaitapp.appclasses.Headwait;

public class RemitFragment extends Fragment {
    private Headwait manuel;
    private NavController navController;
    private RecyclerView recyclerView;
    private RemitAdapter remitAdapter;
    private TextView totalRemit;

    public RemitFragment() {
        // Required empty public constructor
    }
    public static RemitFragment newInstance() {
        RemitFragment fragment = new RemitFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        manuel = RemitFragmentArgs.fromBundle(getArguments()).getHeadWait();
        navController = Navigation.findNavController(view);

        totalRemit = view.findViewById(R.id.FR_total_remit);
        totalRemit.setText("Total Remit: " + manuel.getTotalRemit());

        recyclerView = view.findViewById(R.id.remit_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        remitAdapter = new RemitAdapter(manuel.getServers());
        recyclerView.setAdapter(remitAdapter);

        view.findViewById(R.id.FR_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemitFragmentDirections.ActionRemitFragmentToServersFragment action =
                        RemitFragmentDirections.actionRemitFragmentToServersFragment(manuel);
                navController.navigate(action);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remit, container, false);
    }
}